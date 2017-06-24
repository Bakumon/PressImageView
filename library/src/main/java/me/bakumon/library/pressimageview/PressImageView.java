package me.bakumon.library.pressimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.FloatRange;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 按下效果 ImageView
 * Created by bakumon on 17-6-23.
 */

public class PressImageView extends ImageView {

    @IntDef({PRESS_MODE_NONE, PRESS_MODE_RIPPLE})
    private @interface PressMode {
    }

    public static final int PRESS_MODE_NONE = 0;  // 颜色直接改变
    public static final int PRESS_MODE_RIPPLE = 1;  // 波纹点击效果

    private int pressMode;
    @FloatRange(from = 0.0, to = 2.0)
    private float pressColorBrightness;

    public PressImageView(Context context) {
        this(context, null);
    }

    public PressImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PressImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PressImageView);

        pressMode = ta.getInt(R.styleable.PressImageView_pressMode, PRESS_MODE_NONE);
        pressColorBrightness = ta.getFloat(R.styleable.PressImageView_pressColorBrightness, 0.85F);

        ta.recycle();
    }

    public void setPressColorBrightness(@FloatRange(from = 0.0, to = 2.0) float pressColorBrightness) {
        this.pressColorBrightness = pressColorBrightness;
    }

    public void setPressMode(@PressMode int pressMode) {
        this.pressMode = pressMode;
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        if (pressed) {
            // 校验 pressColorBrightness 的合法性
            if (pressColorBrightness < 0) {
                pressColorBrightness = 0;
            }
            if (pressColorBrightness > 2) {
                pressColorBrightness = 2;
            }
            // 创建颜色矩阵
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                    pressColorBrightness, 0, 0, 0, 0,
                    0, pressColorBrightness, 0, 0, 0,
                    0, 0, pressColorBrightness, 0, 0,
                    0, 0, 0, 1, 0,});
            if (pressMode == PRESS_MODE_RIPPLE) {
                // TODO: 17-6-24 波纹点击效果
                getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            } else { // pressMode 不合法时，默认为 PRESS_MODE_NONE
                getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }

        } else {
            getDrawable().setColorFilter(null);
        }
    }
}
