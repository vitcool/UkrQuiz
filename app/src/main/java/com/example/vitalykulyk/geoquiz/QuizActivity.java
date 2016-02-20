package com.example.vitalykulyk.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class QuizActivity extends ActionBarActivity {

    private static final String KEY_INDEX = "index";


    private ImageButton mTrueButton;
    private ImageButton mFalseButton;
    private ImageButton mCheatButton;
    private ImageButton mNextButton;
    private  ImageButton mPrevButton;
    private ImageView mImageView;
    private TextView mQuestionTextView;
    private TextView mNumberOfQuestion;
    private TextView mTrueAnswers;
    private TextView mTimerQuiz;
    private boolean mIsCheater;
    private int mRightAnswers;
    private int mAllQuestions;
    private int varIndex;
    private MalibuCountDownTimer countDownTimer;//timer
    Timer timer;//timer color
    int randornColor = 0;// randornColor
    private ImageView clockImageView;
    private Animation clockTurnAnimation;
    private Vibrator v;
    private TrueFalse[] mQuestionBank;
    //private boolean[] isAnswered = new boolean[mQuestionBank.length];



    private final long startTime = 15000;
    private final long interval = 100;




    private TrueFalse[] mHistory = new TrueFalse[]{
            new TrueFalse(R.string.history1, R.string.history1_true,false, R.drawable.history1),
            new TrueFalse(R.string.history2, R.string.history2,true, R.drawable.history2),
            new TrueFalse(R.string.history3, R.string.history3,true, R.drawable.history3),
            new TrueFalse(R.string.history4, R.string.history4,true, R.drawable.history4),
            new TrueFalse(R.string.history5, R.string.history5,true, R.drawable.history5),
            new TrueFalse(R.string.history6, R.string.history6_true,false, R.drawable.history6),
            new TrueFalse(R.string.history7, R.string.history7,true, R.drawable.history7),
            new TrueFalse(R.string.history8, R.string.history8_true,false, R.drawable.history8),
            new TrueFalse(R.string.history9, R.string.history9_true,false, R.drawable.history9),
            new TrueFalse(R.string.history10, R.string.history10,true, R.drawable.history10),
    };


    private TrueFalse[] mGeografy = new TrueFalse[]{
            new TrueFalse(R.string.geografy1, R.string.geografy1,true,          R.drawable.geografy1),
            new TrueFalse(R.string.geografy2, R.string.geografy2,true,          R.drawable.geografy2),
            new TrueFalse(R.string.geografy3, R.string.geografy3_true,false,    R.drawable.geografy3),
            new TrueFalse(R.string.geografy4, R.string.geografy4,true,          R.drawable.geografy4),
            new TrueFalse(R.string.geografy5, R.string.geografy5_true,false,    R.drawable.geografy5),
            new TrueFalse(R.string.geografy6, R.string.geografy6_true,false,    R.drawable.geografy6),
            new TrueFalse(R.string.geografy7, R.string.geografy7,true,          R.drawable.geografy7),
            new TrueFalse(R.string.geografy8, R.string.geografy8_true,false,    R.drawable.geografy8),
            new TrueFalse(R.string.geografy9, R.string.geografy9,true,          R.drawable.geografy9),
            new TrueFalse(R.string.geografy10, R.string.geografy10_true,false,  R.drawable.geografy10),
    };

    private TrueFalse[] mScience = new TrueFalse[]{
            new TrueFalse(R.string.science1, R.string.science1,true,                R.drawable.science1),
            new TrueFalse(R.string.science2, R.string.science2_true ,false,         R.drawable.science2),
            new TrueFalse(R.string.science3, R.string.science3,true,                R.drawable.science3),
            new TrueFalse(R.string.science4, R.string.science4,true,                R.drawable.science4),
            new TrueFalse(R.string.science5, R.string.science5_true,false,          R.drawable.science5),
            new TrueFalse(R.string.science6, R.string.science6,true,                R.drawable.science6),
            new TrueFalse(R.string.science7, R.string.science7_true,false,          R.drawable.science7),
            new TrueFalse(R.string.science8, R.string.science8,true,               R.drawable.science8),
            new TrueFalse(R.string.science9, R.string.science9_true,false,          R.drawable.science9),
            new TrueFalse(R.string.science10, R.string.science10,true,              R.drawable.science10),
    };

    private TrueFalse[] mSport = new TrueFalse[]{
            new TrueFalse(R.string.sport1, R.string.sport1_true,false,                R.drawable.sport1),
            new TrueFalse(R.string.sport2, R.string.sport2 ,true,         R.drawable.sport2),
            new TrueFalse(R.string.sport3, R.string.sport3_true,false,                R.drawable.sport3),
            new TrueFalse(R.string.sport4, R.string.sport4,true,                R.drawable.sport4),
            new TrueFalse(R.string.sport5, R.string.sport5_true,false,          R.drawable.sport5),
            new TrueFalse(R.string.sport6, R.string.sport6,true,                R.drawable.sport6),
            new TrueFalse(R.string.sport7, R.string.sport7_true,false,          R.drawable.sport7),
            new TrueFalse(R.string.sport8, R.string.sport8,true,               R.drawable.sport8),
            new TrueFalse(R.string.sport9, R.string.sport9,true,          R.drawable.sport9),
            new TrueFalse(R.string.sport10, R.string.sport10,true,              R.drawable.sport10),
    };

    private TrueFalse[] mAll = new TrueFalse[]{
            new TrueFalse(R.string.geografy8, R.string.geografy8_true,false,    R.drawable.geografy8),
            new TrueFalse(R.string.sport5, R.string.sport5_true,false,          R.drawable.sport5),
            new TrueFalse(R.string.history7, R.string.history7,true, R.drawable.history7),
            new TrueFalse(R.string.science4, R.string.science4,true,                R.drawable.science4),
            new TrueFalse(R.string.sport6, R.string.sport6,true,                R.drawable.sport6),
            new TrueFalse(R.string.science6, R.string.science6,true,                R.drawable.science6),
            new TrueFalse(R.string.science7, R.string.science7_true,false,          R.drawable.science7),
            new TrueFalse(R.string.sport8, R.string.sport8,true,               R.drawable.sport8),
            new TrueFalse(R.string.sport7, R.string.sport7_true,false,          R.drawable.sport7),
            new TrueFalse(R.string.geografy7, R.string.geografy7,true,          R.drawable.geografy7),
    };




    //private TrueFalse[] mQuestionBank = mHistory;

    private int mCurrentIndex = 0;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        int background = mQuestionBank[mCurrentIndex].getBackground();
        clockImageView.startAnimation(clockTurnAnimation);
        mQuestionTextView.setText(question);
        mImageView.setBackgroundResource(background);
        countDownTimer.start();
        mNumberOfQuestion.setText((mCurrentIndex + 1) + " / " + mQuestionBank.length);
        mTrueAnswers.setText(mRightAnswers + " / " + mAllQuestions);
        if (mCurrentIndex == 0) {
            mPrevButton.setVisibility(View.INVISIBLE);
        }
        else {
            mPrevButton.setVisibility(View.VISIBLE);
        }
        if (mCurrentIndex == (mQuestionBank.length - 1)) {
            mNextButton.setVisibility(View.INVISIBLE);
        }
        else {
            mNextButton.setVisibility(View.VISIBLE);
        }
    }

    private void isShowedNext(){
        if (mCurrentIndex < mQuestionBank.length -1 ) {
            if (mQuestionBank[++mCurrentIndex].isAnswered() == true) {
                isShowedNext();
            }
            else {
                --mCurrentIndex;
                nextQuestion();
            }
        }
        else{
            mCurrentIndex = 0;
            isShowedNext();
        }
    }

    private void isShowedPrev(){
        if (mCurrentIndex > 0) {
            if (mQuestionBank[--mCurrentIndex].isAnswered() == true) {
                isShowedPrev();
            }
            else {
                ++mCurrentIndex;
                prevQuestion();
            }
        }
        else{
            mCurrentIndex = mQuestionBank.length;
            isShowedPrev();
        }
    }

    private void prevQuestion(){
        mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
        mIsCheater = false;
        updateQuestion();
    }



    private void nextQuestion(){
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        mIsCheater = false;
        updateQuestion();
    }

    private void checkAnswer(boolean userPressedTrue, ImageButton mButton,ImageButton mOtherButton, Animation animScale){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();

        int messageResId = 0;

        if (mIsCheater){
            messageResId = R.string.judgment_toast;
            nextQuestion();
            updateQuestion();
            mAllQuestions += 1;
        }
        else {
            if (!mQuestionBank[mCurrentIndex].isTrueQuestion()){
                mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getRightAnswer());
            }
            if (userPressedTrue == answerIsTrue) {
                mButton.startAnimation(animScale);
                mRightAnswers += 1;
                mAllQuestions += 1;
                messageResId = R.string.correct_toast;
            } else {
                mOtherButton.startAnimation(animScale);
                // Get instance of Vibrator from current Context
                v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(400);
                /////////////
                messageResId = R.string.incorrect_toast;
                mAllQuestions += 1;
            }

        }

            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }

    private boolean finalQuestion(){
        if (mAllQuestions == mQuestionBank.length){
            Intent i = new Intent(QuizActivity.this, FinalActivity.class);
            i.putExtra("nOfQuestions", mAllQuestions);
            i.putExtra("rigthAnswerd", mRightAnswers);
            startActivity(i);
            return true;
        }
        else return false;
    }

    private void buttonClickable(boolean clickable){
        mTrueButton.setClickable(clickable);
        mFalseButton.setClickable(clickable);
        mNextButton.setClickable(clickable);
        mPrevButton.setClickable(clickable);
        mCheatButton.setClickable(clickable);
    }

    private void checkArray(int randorn){
        switch (randorn){
            case 1: {
                mQuestionBank = mSport;
                return;
            }
            case 2: {
                mQuestionBank = mHistory;
                return;
            }
            case 3: {
                mQuestionBank = mAll;
                return;
            }
            case 4: {
                mQuestionBank = mGeografy;
                return;
            }
            case 5: {
                mQuestionBank = mScience;
                return;
            }
            default: {
                mQuestionBank = mScience;
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        int randorn = intent.getIntExtra("Category", 0);

        checkArray(randorn);


        // Получим ссылку на часы
        clockImageView = (ImageView) findViewById(R.id.clock);
// анимация для вращения часов
        clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);








        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animations);//анімашкі)))

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Timer
        mTimerQuiz = (TextView)findViewById(R.id.timer_quiz);

        countDownTimer = new MalibuCountDownTimer(startTime, interval);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        mTimerQuiz.setTypeface(myTypeface);

        //timer color
        timer = new Timer();
        MyTimerTask myTimerTask=new MyTimerTask();
        timer.schedule(myTimerTask,500,500);
        //mTimerQuiz.setBackgroundResource(R.drawable.clock_green);//timer color

        ///
        mImageView = (ImageView) findViewById(R.id.image_view);
        mRightAnswers = 0;
        mAllQuestions = 0;


        //////
        //Intent intent = getIntent();
        //if (intent.getBooleanExtra("isShowed", true)){
        //    mQuestionBank[mCurrentIndex].setIsAnswered(true);
        //    mCurrentIndex ++;
        //}
        ///////

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        mQuestionTextView.setTypeface(myTypeface);

        mNumberOfQuestion = (TextView)findViewById(R.id.number_qustion);
        mNumberOfQuestion.setText((mCurrentIndex+1) + " / " + mQuestionBank.length);

        mTrueAnswers = (TextView)findViewById(R.id.true_answers);
        mTrueAnswers.setText((mRightAnswers) + " / " + mAllQuestions);



        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });


        mTrueButton = (ImageButton)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true, mTrueButton,mFalseButton, animScale);
                mQuestionBank[mCurrentIndex].setIsAnswered(true);
                buttonClickable(false);
                timer.cancel();
                //if (mCurrentIndex != mQuestionBank.length - 1) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!finalQuestion()) {
                            buttonClickable(true);
                            isShowedNext();
                        }
                    }
                }, 2000);

                //}
            }
        });

        mFalseButton = (ImageButton)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false, mFalseButton,mTrueButton, animScale);
                mQuestionBank[mCurrentIndex].setIsAnswered(true);
                buttonClickable(false);
                timer.cancel();
                //if (mCurrentIndex != mQuestionBank.length - 1) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!finalQuestion()) {
                            buttonClickable(true);
                            isShowedNext();
                        }
                    }
                }, 2000);
                //}
            }
        });

        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varIndex = mCurrentIndex;
                isShowedNext();
            }
        });

        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varIndex = mCurrentIndex;
                isShowedPrev();
            }
        });

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mCheatButton = (ImageButton)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
                startActivityForResult(i, 0);
            }
        });

        updateQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.menu_about: {
                Intent i = new Intent(QuizActivity.this, AboutActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_info: {
                Intent i = new Intent(QuizActivity.this, InfoActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_start: {
                Intent i = new Intent(QuizActivity.this, StartActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_exit: {
                finish();
                moveTaskToBack(true);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null){
            return;
        }
        mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false);
        mQuestionBank[mCurrentIndex].setIsAnswered(mIsCheater);
        if (mIsCheater){
            mAllQuestions += 1;
            if (!mQuestionBank[mCurrentIndex].isTrueQuestion()){
                mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getRightAnswer());
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            buttonClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!finalQuestion()) {
                        buttonClickable(true);
                        isShowedNext();
                    }
                }
            }, 2000);


            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

        //TIMER
    public class MalibuCountDownTimer extends CountDownTimer
    {

        public MalibuCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            mQuestionBank[mCurrentIndex].setIsAnswered(true);
            mAllQuestions++;
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
            isShowedNext();

            //text.setText("Time's up!");
            //timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            mTimerQuiz.setText(String.format("%1$04.1f",Double.valueOf(millisUntilFinished) / 1000));
            //timeElapsed = startTime - millisUntilFinished;
            //timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
//Since we want to change something which is on hte UI
//so we have to run on UI thread..
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    randornColor += 1;
                    if (randornColor % 2 == 1) {
                        //mTimerQuiz.setTextColor(Color.GREEN);
                        //mTimerQuiz.setBackgroundResource(R.drawable.clock_red);
                    } else {
                        //mTimerQuiz.setTextColor(Color.RED);
                        //mTimerQuiz.setBackgroundResource(R.drawable.clock_green);
                    }
                }
            });
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//you have to stop the timer when is your activity has stopped
//otherwise it will keep running in the background
        timer.cancel();
    }
}

