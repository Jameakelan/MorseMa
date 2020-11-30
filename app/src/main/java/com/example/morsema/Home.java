package com.example.morsema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{


    Button thaiBtn,numBtn,symBtn,hisBtn;
    Intent intentOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();

        thaiBtn = findViewById(R.id.thaiOptionBtn);
        numBtn = findViewById(R.id.numberOption);
      //  symBtn = findViewById(R.id.symbolOption);
        hisBtn = findViewById(R.id.historyOption);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.thaiOptionBtn:
                intentOption = new Intent(this,thaiOption.class);
                startActivity(intentOption);
                break;
            case R.id.historyOption:
                intentOption = new Intent(this,MorseHistory.class);
                startActivity(intentOption);
                break;
            case R.id.numberOption:
                intentOption = new Intent(this,NumberCourse.class);
                startActivity(intentOption);
                break;
            case R.id.translateOption:
                intentOption = new Intent(this,translate.class);
                startActivity(intentOption);
                break;
        }
    }
}
