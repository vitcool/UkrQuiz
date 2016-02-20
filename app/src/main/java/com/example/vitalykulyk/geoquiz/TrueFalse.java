package com.example.vitalykulyk.geoquiz;

/**
 * Created by Vitaly Kulyk on 09.02.2016.
 */
public class TrueFalse {
    private int mQuestion;

    private boolean mTrueQuestion;
    private int mBackground;
    private boolean isAnswered;
    private int mRightAnswer;

    public int getBackground() {
        return mBackground;
    }
    public void setBackground(int background) {
        mBackground = background;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public TrueFalse( int question,int rightAnswer, boolean trueQuestion, int background){
        mRightAnswer = rightAnswer;
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mBackground = background;
        isAnswered = false;
    }

    public void setIsAnswered(boolean mIsAnswered) {
        this.isAnswered = mIsAnswered;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public int getRightAnswer() {
        return mRightAnswer;
    }

}
