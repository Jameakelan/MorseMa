package com.example.morsema;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Policy;
import java.util.Arrays;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class translate extends AppCompatActivity {


    EditText editTextMorse;
    TextView morseView;
    Button playBtn,flashlightBtn,playMorse;
    String editTextMorseStr;
    String morseViewConcat = "";
    ClipboardManager clipboard;
    CountDownTimer toastCountDown;
    CameraManager cameraManager;
    String cameraId = null;
    MediaPlayer mediaPlayerDash,mediaPlayerdot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        Intent intent = getIntent();

        editTextMorse = findViewById(R.id.editTextMorse);
        morseView = findViewById(R.id.morseView);
        playBtn = findViewById(R.id.playBtn);
        flashlightBtn = findViewById(R.id.flashlight);
        mediaPlayerDash = MediaPlayer.create(this,R.raw.dash);
        mediaPlayerdot = MediaPlayer.create(this,R.raw.dot);
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clip = ClipData.newPlainText("คัดลอกสำเร็จ", morseViewConcat);
                clipboard.setPrimaryClip(clip);
                final Toast toast = Toast.makeText(getApplicationContext(), "คัดลอกสำเร็จ", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER,0,150);
                toast.show();
                toastCountDown = new CountDownTimer(500,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        toast.show();
                    }
                };
                toastCountDown.start();
            }
        });

        flashlightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashLight(morseViewConcat);
            }
        });

         // ***** Request permission camera

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try {
                cameraId = cameraManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } // end of permission flash light

        // play morse code




        // end of play morse code
    }


    public void translate(View v){

        List<String> alpha = Arrays.asList("ก","ข","ฃ","ค","ฅ","ฆ","ง","จ","ฉ","ช","ซ","ฌ","ญ","ฎ","ฏ","ฐ","ฑ","ฒ","ณ","ด","ต","ถ","ท","ธ"
                ,"น","บ","ป","ผ","ฝ","พ","ฟ","ภ","ม","ย","ร","ล","ว","ศ","ษ","ส","ห","ฬ","อ","ฮ","ฤ","ะ","า","ิ","ี","ึ","ื","ุ","ู","เ","แ","ไ","ใ","โ","ำ","่","้","๊","๋","ั","็","์","ๆ");
        List<String> alphaMorse = Arrays.asList("--.","-.-.","-.-.","-.-","-.-","-.-","-.--.","-..-.","----","-..-","--..","-..-",".----","-..","-","-.-..","-..--","-..--"
                ,"-.","-..","-","-.-..","-..--","-..--","-.","-...",".--.","--.-","-.-.-",".--..","..-.",".--..","--","-.--",".-.",".-..",".--","...","...","...","....",".-..","-...-","--.--"
                ,".-.--",".-...",".-","..-..","..","..--.","..--","..-.-","---.",".",".-.-",".-..-",".-..-","---","...-.","..-","...-","--...",".-.-.",".--.-","---..","--..-","-.---");
        List<String> number = Arrays.asList("1","2","3","4","5","6","7","8","9","0");
        List<String> numberMorse = Arrays.asList(".----","..---","...--","....-",".....","-....","--...","---..","----.","-----");
        List<String> symbol = Arrays.asList(".",",","?","'","!","/","(",")","&",":",";","=","-","_","\"","$","@");
        List<String> symbolMorse = Arrays.asList(".-.-.-","--..--","..--..",".----.","-.-.--","-..-.",".-.--.","-.--.-",".-...","---...","-.-.-.","-...-","-....-","..--.-",".-..-.","...-..-",".--.-.");
        editTextMorseStr = editTextMorse.getText().toString();



        char[] strArray = editTextMorseStr.toCharArray();


        int index;
        morseViewConcat="";
       for(char ch : strArray){
           Log.d("jame",ch+"");
          String strCh = String.format("%s",ch);
           if(alpha.contains(strCh)){
               index = alpha.indexOf(strCh);
               morseViewConcat = morseViewConcat.concat(alphaMorse.get(index)+" ");
           }else if(number.contains(strCh)){
               index = number.indexOf(strCh);
               morseViewConcat = morseViewConcat.concat(numberMorse.get(index)+" ");
           }else if(symbol.contains(strCh)){
               index = symbol.indexOf(strCh);
               morseViewConcat =morseViewConcat.concat(symbolMorse.get(index)+" ");
           }else if(strCh.equals(" ")){

           }else{
               morseViewConcat = morseViewConcat.concat("# ");
           }
       }
        morseView.setText(morseViewConcat);

    } // end of translate
    public void backToHomeThai(View view){
        onBackPressed();
    }

    public void flashLight(String morseCode){

        char[] charArray = morseCode.toCharArray();

        for (char ch : charArray){
            if (ch == '.'){
                setFlashLightOnDot();
                setFlashLightOff();

                Log.d("jame",".");
            }else if(ch=='-'){

                setFlashLightOnDash();
                setFlashLightOff();

                Log.d("jame","-");
            }else{
                setFlashLightNull();
                Log.d("jame"," ");
            }
        }

    }

    private void setFlashLightOnDash(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {

                    cameraManager.setTorchMode(cameraId,true);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }

        } // end fo if Build VERSION
    }

    private void setFlashLightOnDot(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            try {

                cameraManager.setTorchMode(cameraId,true);
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        } // end fo if Build VERSION
    }

    private void setFlashLightOff(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            try {


                cameraManager.setTorchMode(cameraId,false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        } // end fo if Build VERSION
    }

    private void setFlashLightNull(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            try {


                cameraManager.setTorchMode(cameraId,false);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        } // end fo if Build VERSION
    }

}
