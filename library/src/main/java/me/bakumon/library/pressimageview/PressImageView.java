package me.bakumon.library.pressimageview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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
            0.1F, 0, 0, 0, 0,
            0, 0.1F, 0, 0, 0,
            0, 0, 0.1F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix1 = new ColorMatrix(new float[]{
            0.2F, 0, 0, 0, 0,
            0, 0.2F, 0, 0, 0,
            0, 0, 0.2F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix2 = new ColorMatrix(new float[]{
            0.3F, 0, 0, 0, 0,
            0, 0.3F, 0, 0, 0,
            0, 0, 0.3F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix3 = new ColorMatrix(new float[]{
            0.4F, 0, 0, 0, 0,
            0, 0.4F, 0, 0, 0,
            0, 0, 0.4F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix4 = new ColorMatrix(new float[]{
            0.5F, 0, 0, 0, 0,
            0, 0.5F, 0, 0, 0,
            0, 0, 0.5F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix5 = new ColorMatrix(new float[]{
            0.6F, 0, 0, 0, 0,
            0, 0.6F, 0, 0, 0,
            0, 0, 0.6F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix6 = new ColorMatrix(new float[]{
            0.7F, 0, 0, 0, 0,
            0, 0.7F, 0, 0, 0,
            0, 0, 0.7F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix7 = new ColorMatrix(new float[]{
            0.8F, 0, 0, 0, 0,
            0, 0.8F, 0, 0, 0,
            0, 0, 0.8F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix8 = new ColorMatrix(new float[]{
            0.9F, 0, 0, 0, 0,
            0, 0.9F, 0, 0, 0,
            0, 0, 0.9F, 0, 0,
            0, 0, 0, 1, 0,});
    final ColorMatrix colorMatrix9 = new ColorMatrix(new float[]{
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0,});


    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);

        Drawable[] drawables = new Drawable[2];
        drawables[0] = getDrawable();

        LayerDrawable layerDrawable = new LayerDrawable(drawables);

        if (pressed) {
            setClickable(false);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix9));
                }
            }, 100);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix8));
                }
            }, 200);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix7));
                }
            }, 300);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix6));
                }
            }, 400);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix5));
                }
            }, 500);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix4));
                }
            }, 600);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix3));
                }
            }, 700);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix2));
                }
            }, 800);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix1));
                }
            }, 900);

            postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDrawable().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    getDrawable().clearColorFilter();
                    setClickable(true);
                }
            }, 1000);
        } else {
            getDrawable().clearColorFilter();
        }
    }
}
