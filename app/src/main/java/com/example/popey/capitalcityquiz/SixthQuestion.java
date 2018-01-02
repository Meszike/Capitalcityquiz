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

public class SixthQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int capitalCityCount6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            goodAnswer = extras.getInt("adom");

        RadioButton Warsaw = (RadioButton) findViewById(R.id.Warsaw);
        RadioButton Bogota = (RadioButton) findViewById(R.id.Bogota);
        RadioButton Oslo = (RadioButton) findViewById(R.id.Oslo);
        Button next = (Button) findViewById(R.id.button_next);

    }
    //evaluation
    public void rightSixthQuestion(View v) {
        RadioButton Warsaw = (RadioButton) findViewById(R.id.Warsaw);
        RadioButton Bogota = (RadioButton) findViewById(R.id.Bogota);
        RadioButton Oslo = (RadioButton) findViewById(R.id.Oslo);
        if (Warsaw.isChecked()) {
            if (capitalCityCount6 == 0)
                goodAnswer++;
            nextToSeventhQuestion(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Warsaw.setChecked(false);
            Bogota.setChecked(false);
            Oslo.setChecked(false);
            capitalCityCount6++;
        }
    }
    // next button click

    private void nextToSeventhQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, SeventhQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}