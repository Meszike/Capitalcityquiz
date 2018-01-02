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

public class SecondQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int capitalCityCount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            goodAnswer = extras.getInt("adom");

        RadioButton Bukarest = (RadioButton) findViewById(R.id.Bukarest);
        RadioButton Zagreb = (RadioButton) findViewById(R.id.Zagreb);
        RadioButton Budapest = (RadioButton) findViewById(R.id.Budapest);
        Button next = (Button) findViewById(R.id.button_next);

    }
      //evolut
    public void rightSecondQuestion(View v) {
        RadioButton Bukarest = (RadioButton) findViewById(R.id.Bukarest);
        RadioButton Zagreb = (RadioButton) findViewById(R.id.Zagreb);
        RadioButton Budapest = (RadioButton) findViewById(R.id.Budapest);
        if (Budapest.isChecked()) {
            if (capitalCityCount2 == 0) {
                goodAnswer++;
            }
            nextToThirdQuestion(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Bukarest.setChecked(false);
            Zagreb.setChecked(false);
            Budapest.setChecked(false);
            capitalCityCount2++;
        }
    }
    // next button click
    private void nextToThirdQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, ThirdQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}
