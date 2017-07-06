package me.bakumon.library.pressimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 按下效果 ImageView
 * Created by bakumon on 17-6-23.
 */

public class PressImageView extends ImageView {

    // 默认颜色矩阵系数
    private static final float DEFAULT_BRIGHTNESS = 0.85F;

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

        pressColorBrightness = ta.getFloat(R.styleable.PressImageView_pressColorBrightness, DEFAULT_BRIGHTNESS);

        ta.recycle();
    }

    public void setPressColorBrightness(@FloatRange(from = 0.0, to = 2.0) float pressColorBrightness) {
        this.pressColorBrightness = pressColorBrightness;
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        if (pressed) {
            setDrawableColorFilter();
        } else {
            getDrawable().setColorFilter(null);
        }
    }

    /**
     * 设置 drawable 的按下效果
     */
    private void setDrawableColorFilter() {
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

        getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
