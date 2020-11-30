package com.example.morsema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharePre;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharePre = PreferenceManager.getDefaultSharedPreferences(this);

        super.onCreate(savedInstanceState);

        int checkNum = sharePre.getInt("checkNum",0);
        setContentView(R.layout.activity_main);
        if(checkNum==1){
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
        }

    }

    public void send(View view){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);

        editor = sharePre.edit();
        editor.putInt("checkNum",1);
        editor.commit();
    }
}
