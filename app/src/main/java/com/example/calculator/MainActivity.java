package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    int[]  mOperators = {R.id.btn_plus,R.id.btn_minus,R.id.btn_mul,R.id.btn_div};
    public static int[] mSpeeds = {1500,2000,3000,4000};
    public static int mSpeedId = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMain(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("operator",getOperatorById(view.getId()));
        startActivity(intent);
    }

    public void launchConfig(View view){
        Intent intent = new Intent(this,ConfigActivity.class);
        startActivity(intent);
    }

    private int getOperatorById(int id){
        int index=0;
        for (index=0;index<4;index++){
            if (mOperators[index] == id)
                return index;
        }
        return index;
    }
}