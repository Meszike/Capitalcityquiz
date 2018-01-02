package com.example.popey.capitalcityquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by POPEY on 2018. 01. 02..
 */

public class SeventhQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int lastCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            goodAnswer = extras.getInt("adom");
        CheckBox Canberra = (CheckBox) findViewById(R.id.Canberra);
        CheckBox Paris = (CheckBox) findViewById(R.id.Paris);
        CheckBox Vienna = (CheckBox) findViewById(R.id.Vienna);
        CheckBox Madrid = (CheckBox) findViewById(R.id.Madrid);
        CheckBox Rome = (CheckBox) findViewById(R.id.Rome);
        CheckBox Bern = (CheckBox) findViewById(R.id.Bern);
        Button next = (Button) findViewById(R.id.button_next);

    }
    //evaluation
    public void rightSeventhQuestion(View v) {
        CheckBox Canberra = (CheckBox) findViewById(R.id.Canberra);
        CheckBox Paris = (CheckBox) findViewById(R.id.Paris);
        CheckBox Vienna = (CheckBox) findViewById(R.id.Vienna);
        CheckBox Madrid = (CheckBox) findViewById(R.id.Madrid);
        CheckBox Rome = (CheckBox) findViewById(R.id.Rome);
        CheckBox Bern = (CheckBox) findViewById(R.id.Bern);
        if (Canberra.isChecked() && Paris.isChecked()  && Madrid.isChecked() && Rome.isChecked() && Bern.isChecked()) {
            if (lastCount == 0)
                goodAnswer++;
            nextToLastView(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Canberra.setChecked(false);
            Paris.setChecked(false);
            Vienna.setChecked(false);
            Madrid.setChecked(false);
            Rome.setChecked(false);
            Bern.setChecked(false);
            lastCount++;
        }
    }
    // next button click
    private void nextToLastView(View v, String name, int value) {
        Intent intent = new Intent(this, LastActivity.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}