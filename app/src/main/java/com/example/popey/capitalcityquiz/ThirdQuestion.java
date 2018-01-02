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

public class ThirdQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int capitalCityCount3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            goodAnswer = extras.getInt("adom");
        RadioButton Minsk = (RadioButton) findViewById(R.id.Minsk);
        RadioButton Ulaanbaatar = (RadioButton) findViewById(R.id.Ulaanbaatar);
        RadioButton KualaLumpur = (RadioButton) findViewById(R.id.KualaLumpur);
        Button next = (Button) findViewById(R.id.button_next);

    }
    //evaluation
    public void rightThirdQuestion(View v) {
        RadioButton Minsk = (RadioButton) findViewById(R.id.Minsk);
        RadioButton Ulaanbaatar = (RadioButton) findViewById(R.id.Ulaanbaatar);
        RadioButton KualaLumpur = (RadioButton) findViewById(R.id.KualaLumpur);
        if (Ulaanbaatar.isChecked()) {
            if (capitalCityCount3 == 0)
                goodAnswer++;
            nextToFourthQuestion(v, "adom", goodAnswer);
        } else {
            Toast.makeText(this, "Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            Minsk.setChecked(false);
            Ulaanbaatar.setChecked(false);
            KualaLumpur.setChecked(false);
            capitalCityCount3++;
        }
    }

    private void nextToFourthQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, FourthQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}

