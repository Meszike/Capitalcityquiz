package com.example.popey.capitalcityquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by POPEY on 2018. 01. 02..
 */

public class LastActivity extends AppCompatActivity {
    private int goodAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_last);
        Intent intent = getIntent();

        //evaluation message and result
        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            goodAnswer = extras.getInt("adom");
            TextView percent = (TextView) findViewById(R.id.percent);
            double result = goodAnswer/7.0*100.0;
            percent.setText("" + (int)result + "%");
            if (result>=0)
                setTextEvaluation("Do not give up! You have to practice more.", "#D84315");
            if (result>30)
                setTextEvaluation("Do not to give up! Not to bad, but you have to practice more.", "#FB8C00");
            if (result>60)
                setTextEvaluation("This is a really nice result. You're smart.", "#000000");
            if (result>80)
                setTextEvaluation("You are awesome indeed!", "#2E7D32");
        }

        Button restart = (Button)findViewById(R.id.button_restart);

    }

    private void setTextEvaluation(String advice, String colorOfText){
        TextView evaluation = (TextView)findViewById(R.id.evaluation);
        evaluation.setText(advice);
        evaluation.setTextColor(Color.parseColor(colorOfText));
    }
    //onClick restart button
    public void restart(View v){
        Intent intent = new Intent(this, FirstQuestion.class);
        startActivity(intent);
    }
}