package me.bakumon.pressimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.bakumon.library.pressimageview.PressImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PressImageView pressImageView = (PressImageView) findViewById(R.id.press_imageview);
        pressImageView.setPressColorBrightness(0.8f);
        pressImageView.setPressMode(PressImageView.PRESS_MODE_NONE);
    }
}
