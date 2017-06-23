package me.bakumon.library.pressimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 按下效果 ImageView
 * Created by bakumon on 17-6-23.
 */

public class PressImageView extends ImageView {

    private static final int PRESS_MODE_NONE = 0;  // 颜色直接改变
    private static final int PRESS_MODE_RIPPLE = 1;  // 波纹点击效果

    private int pressMode;

    private ColorMatrix colorMatrix;

    public PressImageView(Context context) {
        this(context, null);
    }

    public PressImageView(Context context, AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public PressImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PressImageView);

        pressMode = ta.getInt(R.styleable.PressImageView_pressMode, PRESS_MODE_NONE);
        float pressColorBrightness = ta.getFloat(R.styleable.PressImageView_pressColorBrightness, 0.85F);

        if (pressColorBrightness < 0) {
            pressColorBrightness = 0;
        }
        if (pressColorBrightness > 2) {
            pressColorBrightness = 2;
        }

        colorMatrix = new ColorMatrix(new float[]{
                pressColorBrightness, 0, 0, 0, 0,
                0, pressColorBrightness, 0, 0, 0,
                0, 0, pressColorBrightness, 0, 0,
                0, 0, 0, 1, 0,});
        ta.recycle();
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        if (pressed) {
            if (pressMode == PRESS_MODE_NONE) {
                getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            } else if (pressMode == PRESS_MODE_RIPPLE) {
                // TODO: 17-6-24 波纹点击效果
                getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }

        } else {
            getDrawable().setColorFilter(null);
        }
    }
}
