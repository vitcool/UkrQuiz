package com.example.vitalykulyk.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Vitaly Kulyk on 13.02.2016.
 */
public class StartActivity extends Activity {

    final Random random = new Random();


    private ImageButton startTestButton;
    private ImageButton infoButton;
    private ImageButton aboutButton;
    private ImageButton exitButton;
    private RelativeLayout relativeLayout;
    private TextView textView;

    private void randomBackground(){
        int rand = random.nextInt(5);
        switch (rand){
            case 1: {
                relativeLayout.setBackgroundResource(R.drawable.background_main);
                break;
            }
            case 2: {
                relativeLayout.setBackgroundResource(R.drawable.background_main_1);
                break;
            }
            case 3: {
                relativeLayout.setBackgroundResource(R.drawable.background_main_2);
                break;
            }
            case 4: {
                relativeLayout.setBackgroundResource(R.drawable.background_main_3);
                break;
            }
            case 5: {
                relativeLayout.setBackgroundResource(R.drawable.background_main_4);
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animations);
        final Animation animTramslate = AnimationUtils.loadAnimation(this, R.anim.translate_anim);

        textView = (TextView)findViewById(R.id.start_view);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        textView.setTypeface(myTypeface);

        relativeLayout = (RelativeLayout)findViewById(R.id.start_screen);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomBackground();
            }
        });


        randomBackground();


        startTestButton = (ImageButton) findViewById(R.id.start_test);
        startTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(StartActivity.this, ChangingActivity.class);
                startActivity(i);
            }
        });


        infoButton = (ImageButton) findViewById( R.id.info_btn);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTramslate);
                Intent i = new Intent(StartActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });


        aboutButton = (ImageButton) findViewById( R.id.about_btn);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTramslate);
                Intent i = new Intent(StartActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });



        exitButton = (ImageButton)findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTramslate);
                finish();
                moveTaskToBack(true);
            }
        });


    }
}
