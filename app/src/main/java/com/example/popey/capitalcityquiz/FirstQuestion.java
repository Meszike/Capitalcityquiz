package com.example.popey.capitalcityquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by POPEY on 2018. 01. 02..
 */

public class FirstQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int capitalCityCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Intent intent = getIntent();
        RadioButton ottawa = (RadioButton) findViewById(R.id.ottawa);
        RadioButton Washington = (RadioButton) findViewById(R.id.Washington);
        RadioButton Prague = (RadioButton) findViewById(R.id.Prague);
        Button next = (Button) findViewById(R.id.button_next);

    }

    public void rightFirstQuestion(View v) {
        RadioButton ottawa = (RadioButton) findViewById(R.id.ottawa);
        RadioButton Washington = (RadioButton) findViewById(R.id.Washington);
        RadioButton Prague = (RadioButton) findViewById(R.id.Prague);


        //evaluation
        if (ottawa.isChecked()) {
            if (capitalCityCount == 0) {
                goodAnswer++;
            }
            nextToSecondQuestion(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Prague.setChecked(false);
            Washington.setChecked(false);
            ottawa.setChecked(false);
            capitalCityCount++;
        }
    }
    // next button click
    private void nextToSecondQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, SecondQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);

    }


}
