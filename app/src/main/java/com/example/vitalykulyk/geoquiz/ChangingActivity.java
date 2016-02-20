package com.example.vitalykulyk.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Vitaly Kulyk on 16.02.2016.
 */
public class ChangingActivity extends Activity {

    private ImageButton mSportImg;
    private ImageButton mHistoryImg;
    private ImageButton mInterestImg;
    private ImageButton mGeografyImg;
    private ImageButton mScienceImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animations);

        mSportImg = (ImageButton)findViewById(R.id.sport_img);
        mSportImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(ChangingActivity.this, QuizActivity.class);
                i.putExtra("Category", 1);
                startActivity(i);
            }
        });

        mHistoryImg = (ImageButton)findViewById(R.id.history_img);
        mHistoryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(ChangingActivity.this, QuizActivity.class);
                i.putExtra("Category", 2);
                startActivity(i);
            }
        });

        mInterestImg = (ImageButton)findViewById(R.id.interesting_img);
        mInterestImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(ChangingActivity.this, QuizActivity.class);
                i.putExtra("Category", 3);
                startActivity(i);
            }
        });

        mGeografyImg = (ImageButton)findViewById(R.id.geografy_img);
        mGeografyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(ChangingActivity.this, QuizActivity.class);
                i.putExtra("Category", 4);
                startActivity(i);
            }
        });

        mScienceImg = (ImageButton)findViewById(R.id.science_img);
        mScienceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent i = new Intent(ChangingActivity.this, QuizActivity.class);
                i.putExtra("Category", 5);
                startActivity(i);
            }
        });

    }
}
