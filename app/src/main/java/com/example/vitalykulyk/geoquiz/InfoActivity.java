package com.example.vitalykulyk.geoquiz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Vitaly Kulyk on 13.02.2016.
 */
public class InfoActivity extends Activity {

    private TextView info1;

    private TextView info3;
    private TextView info2;
    private TextView info4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        info1 = (TextView)findViewById(R.id.info1);
        info2 = (TextView)findViewById(R.id.info2);
        info3 = (TextView)findViewById(R.id.info3);
        info4 = (TextView)findViewById(R.id.info4);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        info1.setTypeface(myTypeface);
        info2.setTypeface(myTypeface);
        info3.setTypeface(myTypeface);
        info4.setTypeface(myTypeface);
    }
}
