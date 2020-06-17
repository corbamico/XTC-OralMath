package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfigActivity extends Activity {
    TextView mTextView;
    int mSpeedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        mTextView = findViewById(R.id.textView_Speed);
        mSpeedId = MainActivity.mSpeedId;
        updateSpeedView();
    }

    private void updateSpeedView(){
        mTextView.setText(String.format("间隔: %.1f秒",(float)MainActivity.mSpeeds[mSpeedId]/1000));
        MainActivity.mSpeedId = mSpeedId;
    }
    public void incSpeed(View view){
        if (mSpeedId<3) {
            mSpeedId++;
            updateSpeedView();
        }
    }
    public void decSpeed(View view){
        if (mSpeedId>0){
            mSpeedId--;
            updateSpeedView();
        }
    }
}