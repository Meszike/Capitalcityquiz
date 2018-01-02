package com.example.popey.capitalcityquiz;

        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int goodAnswerFirst = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ok = (Button) findViewById(R.id.button_ok);
        Button next = (Button) findViewById(R.id.button_next);

    }

    //ok button click
    public void ok(View v) {
        TextView introduction = (TextView) findViewById(R.id.introduction);
        String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString();
        String introductionText = "Hello " + name + "! Are you ready? Please PRESS the NEXT Button!";
        introduction.setText(introductionText);
        introduction.setTextColor(Color.parseColor("#FFFF00"));
    }

     // next button click
    public void nextToFirstQuestion(View v){
        Intent intent = new Intent(this, FirstQuestion.class);
        startActivity(intent);
    }


}
