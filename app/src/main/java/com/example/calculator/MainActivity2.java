package com.example.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends Activity {
    TextView mTextView,mTextViewRemain;
    Random   random = new Random();
    int      mOperator = 0;//0-3,+-*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = findViewById(R.id.textView);
        mTextViewRemain = findViewById(R.id.textView_Remain);
        mOperator = getIntent().getIntExtra("operator",0);

        new CountDownTimer(120000,MainActivity.mSpeeds[MainActivity.mSpeedId]){
            @Override
            public void onTick(long l) {
                mTextView.setText(generateText(mOperator));
                mTextViewRemain.setText(String.format("还剩%d秒",l/1000));
            }

            @Override
            public void onFinish() {
                mTextView.setTextSize(2,32);
                mTextView.setText("完成练习");
                mTextViewRemain.setText("");
            }
        }.start();
    }

    public String generateText(int opType){
        int a = random.nextInt(8)+2;
        int b = random.nextInt(8)+2;
        switch (opType){
            case 0:
                while(a+b<10) {
                    a = random.nextInt(8)+2;
                    b = random.nextInt(8)+2;
                }
                return String.format("%d+%d",a,b);
            case 1:
                while(a+b<10) {
                    a = random.nextInt(8)+2;
                    b = random.nextInt(8)+2;
                }
                return String.format("%d-%d",a+b,b);
            case 2:
                return String.format("%d×%d",a,b);
            case 3:
                return String.format("%d÷%d",a*b,b);
        }
        return  "";
    }
}