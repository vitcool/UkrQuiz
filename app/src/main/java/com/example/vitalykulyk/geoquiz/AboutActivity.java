package com.example.vitalykulyk.geoquiz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Vitaly Kulyk on 13.02.2016.
 */
public class AboutActivity extends Activity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        text1 = (TextView)findViewById(R.id.about_1);
        text2 = (TextView)findViewById(R.id.about_2);
        text3 = (TextView)findViewById(R.id.about_3);
        text4 = (TextView)findViewById(R.id.about_4);
        text5 = (TextView)findViewById(R.id.about_5);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        text1.setTypeface(myTypeface);
        text2.setTypeface(myTypeface);
        text3.setTypeface(myTypeface);
        text4.setTypeface(myTypeface);
        text5.setTypeface(myTypeface);

    }

}
