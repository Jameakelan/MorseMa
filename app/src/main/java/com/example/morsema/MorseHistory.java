package com.example.morsema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MorseHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse_history);
        Intent intent = getIntent();
    }
    public void backToHomeThai(View view){
        onBackPressed();
    }
}
