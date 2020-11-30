package com.example.morsema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class thaiOption extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_option);

        Intent intentThai = getIntent();

    }

    public void backToHomeThai(View view){
        onBackPressed();
    }

    public void sendToThaiCourse(View view){
        switch(view.getId()){
            case R.id.thaiOption:
                intent = new Intent(this,thaiCourse.class);
                startActivity(intent);
                break;
            case R.id.thaiVowel:
                intent = new Intent(this,vowelCourse.class);
                startActivity(intent);
                break;
            case R.id.toneMarkID:

                intent = new Intent(this,toneMarkCourse.class);
                startActivity(intent);
               break;
            case R.id.thaiSymbol:

                intent = new Intent(this,thaiSymbolCourse.class);
                startActivity(intent);
                break;
        }
    }
}
