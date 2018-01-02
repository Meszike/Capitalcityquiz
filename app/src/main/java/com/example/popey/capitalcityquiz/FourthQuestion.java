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

public class FourthQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int capitalCityCount4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            goodAnswer = extras.getInt("adom");

        RadioButton Monaco = (RadioButton) findViewById(R.id.Monaco);
        RadioButton BuenosAires = (RadioButton) findViewById(R.id.BuenosAires);
        RadioButton Dublin = (RadioButton) findViewById(R.id.Dublin);
        Button next = (Button) findViewById(R.id.button_next);

    }
    //evaluation

    public void rightFourthQuestion(View v) {
        RadioButton Monaco = (RadioButton) findViewById(R.id.Monaco);
        RadioButton BuenosAires = (RadioButton) findViewById(R.id.BuenosAires);
        RadioButton Dublin = (RadioButton) findViewById(R.id.Dublin);
        if (BuenosAires.isChecked()) {
            if (capitalCityCount4 == 0)
                goodAnswer++;
            nextToFifthQuestion(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Monaco.setChecked(false);
            BuenosAires.setChecked(false);
            Dublin.setChecked(false);
            capitalCityCount4++;
        }
    }
    // next button click
    private void nextToFifthQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, FifthQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}