package com.example.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends Activity {
    TextView mTextView, mTextViewRemain,mTextViewResult;
    final Random random = new Random();
    ///0: 20以内加法
    ///1：20以内减法
    ///2: 乘法
    ///3: 除法
    ///4: 10以内加法
    ///5：10以内减法
    int mOperator = 0;

    String mCalculator,mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = findViewById(R.id.textView);
        mTextViewRemain = findViewById(R.id.textView_Remain);
        mTextViewResult = findViewById(R.id.textView_Result);

        mOperator = getIntent().getIntExtra("operator", 0);

        new CountDownTimer(120000, MainActivity.mSpeeds[MainActivity.mSpeedId]) {
            @Override
            public void onTick(long l) {
                mTextView.setText(generateText(mOperator));
                mTextViewRemain.setText(String.format("还剩%d秒", l / 1000));

                if (MainActivity.mShowResult){
                    mTextViewResult.setText(mResult);
                }
            }

            @Override
            public void onFinish() {
                mTextView.setTextSize(2, 32);
                mTextView.setText("完成练习");
                mTextViewRemain.setText("");
            }
        }.start();
    }

    public String generateText(int opType) {
        int a = random.nextInt(8) + 2;
        int b = random.nextInt(8) + 2;
        switch (opType) {
            case 0:
                while (a + b < 10) {
                    a = random.nextInt(8) + 2;
                    b = random.nextInt(8) + 2;
                }
                mCalculator= String.format("%d+%d", a, b);
                mResult = String.format("%d",a+b);
                return mCalculator;
            case 1:
                while (a + b < 10) {
                    a = random.nextInt(8) + 2;
                    b = random.nextInt(8) + 2;
                }
                mCalculator= String.format("%d-%d", a + b, b);
                mResult = String.format("%d",a);
                return mCalculator;
            case 2:
                mCalculator= String.format("%d×%d", a, b);
                mResult = String.format("%d",a*b);
                return mCalculator;
            case 3:
                mCalculator= String.format("%d÷%d", a * b, b);
                mResult = String.format("%d",a);
                return mCalculator;
            case 4:
                //10以内加法
                while (a + b > 10) {
                    a = random.nextInt(9) + 1;
                    b = random.nextInt(9) + 1;
                }
                mCalculator= String.format("%d+%d", a , b);
                mResult = String.format("%d",a+b);
                return mCalculator;
            case 5:
                //10以内减法
                while (a + b > 10) {
                    a = random.nextInt(9) + 1;
                    b = random.nextInt(9) + 1;
                }
                mCalculator= String.format("%d-%d", a+b , b);
                mResult = String.format("%d",a);
                return mCalculator;
        }
        return "";
    }
}