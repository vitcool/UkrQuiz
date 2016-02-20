package com.example.vitalykulyk.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Vitaly Kulyk on 13.02.2016.
 */
public class FinalActivity extends Activity {

    private TextView resultView;
    private RelativeLayout resultLayout;
    private ImageButton exit_button;
    private ImageView background;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        background = (ImageView)findViewById(R.id.background_img);

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animations);

        resultView = (TextView) findViewById(R.id.result);
        resultView.setTypeface(myTypeface);
        resultLayout = (RelativeLayout)findViewById(R.id.resultLinear);

        textView = (TextView)findViewById(R.id.textView2);
        textView.setTypeface(myTypeface);

        Intent intent = getIntent();

        double allOfQuestions = (double)intent.getIntExtra("nOfQuestions", 5);
        double rightAnswers = (double)intent.getIntExtra("rigthAnswerd", 1);

        double result = (rightAnswers / allOfQuestions);

        Random random = new Random();
        int []backgroundImg = new int [5];
        int []text = new int [5];
        backgroundImg[0] = R.drawable.sheva;
        text[0] = R.string.sheva;
        backgroundImg[1] = R.drawable.lesja;
        text[1] = R.string.lesja;
        backgroundImg[2] = R.drawable.lina;
        text[2] = R.string.lina;
        backgroundImg[3] = R.drawable.franko;
        text[3] = R.string.franko;
        backgroundImg[4] = R.drawable.simonenko;
        text[4] = R.string.lesja;

        int randorn = random.nextInt(4);
        background.setBackgroundResource(backgroundImg[randorn]);
        textView.setText(text[randorn]);

        exit_button = (ImageButton)findViewById(R.id.exit_button);
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                finish();
                moveTaskToBack(true);
            }
        });


        resultView.setText("" + result*100 + "%");
    }
}
