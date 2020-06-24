package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class ConfigActivity extends Activity {
    TextView mTextView;
    CheckBox mCheckBox;
    int mSpeedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        mTextView = findViewById(R.id.textView_Speed);
        mSpeedId = MainActivity.mSpeedId;
        mCheckBox = (CheckBox)findViewById(R.id.checkBox_Result);
        mCheckBox.setChecked(MainActivity.mShowResult);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MainActivity.mShowResult = b;
            }
        });

        updateSpeedView();
    }

    private void updateSpeedView() {
        mTextView.setText(String.format("间隔: %.1f秒", (float) MainActivity.mSpeeds[mSpeedId] / 1000));
        MainActivity.mSpeedId = mSpeedId;
    }

    public void incSpeed(View view) {
        if (mSpeedId < 3) {
            mSpeedId++;
            updateSpeedView();
        }
    }

    public void decSpeed(View view) {
        if (mSpeedId > 0) {
            mSpeedId--;
            updateSpeedView();
        }
    }
}