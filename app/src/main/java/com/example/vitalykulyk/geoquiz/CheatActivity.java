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
import android.widget.TextView;

import java.awt.font.TextAttribute;

/**
 * Created by Vitaly Kulyk on 11.02.2016.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.vitalykulyk.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.example.vitalykulyk.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private ImageButton mShowAnswer;

    private boolean isShowed;


    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        isShowed = false;

        setAnswerShownResult(false);

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animations);
        final Animation animTramslate = AnimationUtils.loadAnimation(this, R.anim.translate_anim);

        final Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mAnswerTextView.setTypeface(myTypeface);


        mShowAnswer = (ImageButton) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////////
                //QuizActivity.mQuestionBank[mCurrentIndex].setIsAnswered(true);
                //QuizActivity.mCurrentIndex++;
                //QuizActivity.updateQuestion();
                isShowed = true;
                //////////
                v.startAnimation(animScale);
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);

                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                mAnswerTextView.setTypeface(myTypeface);
                mAnswerTextView.setTextSize(50);
                mAnswerTextView.setBackgroundResource(R.drawable.button_false);
                mShowAnswer.setVisibility(View.INVISIBLE);
                setAnswerShownResult(true);
            }
        });

    }
}
