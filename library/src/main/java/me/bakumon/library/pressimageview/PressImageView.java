package me.bakumon.library.pressimageview;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 按下效果 ImageView
 * Created by bakumon on 17-6-23.
 */

public class PressImageView extends ImageView {


    public PressImageView(Context context) {
        super(context);
    }

    public PressImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PressImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    final ColorMatrix colorMatrix = new ColorMatrix(new float[]{
            0.5F, 0, 0, 0, 0,
            0, 0.5F, 0, 0, 0,
            0, 0, 0.5F, 0, 0,
            0, 0, 0, 1, 0,});

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        if (pressed) {
            getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } else {
            getDrawable().setColorFilter(null);
        }
    }
}
