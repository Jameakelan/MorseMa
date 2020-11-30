package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class course extends AppCompatActivity {

    TextView textViewMorseWrite,textViewMorse,textViewAlpha, courseHeader;
    String strMorse="";
    String[] arrayAlpha ,arrayMorse;
    String strCourseHeader;
    private int lenArrayAlpha;
    private int checkCountCorrect=0,checkCountMorse=0;
    itemTool builderItem;
    MorseAndAlpha morseAndAlpha;
    AlertDialog dialog;
    Button positiveButton;
    Vibrator v;
    String typeCourse;
    String checkSend;
     MediaPlayer sound,sound2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Intent intent = getIntent();

        // instance adn service
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // item tool builder alert
         sound = MediaPlayer.create(this,R.raw.dot);
         sound2 = MediaPlayer.create(this,R.raw.dash);

        builderItem = new itemTool(course.this);

        // text view morse
        textViewMorseWrite = findViewById(R.id.textViewArrayMorseWrite);
        textViewAlpha = findViewById(R.id.textViewArrayAlpha);
        textViewMorse = findViewById(R.id.textViewArrayMorse);


        // get string for intent

        checkSend = intent.getStringExtra("checkSend");


       // checkSend = intent.getStringExtra("checkSend");

        // type that from difference class as such as thaiCourse vowelCourse ect.
        if(checkSend.equals("1")){

            strCourseHeader = intent.getStringExtra(thaiCourse.EXTRA_COURSEHEADER);
            typeCourse = intent.getStringExtra(thaiCourse.EXTRA_TYPECOURSE);

        }else if(checkSend.equals("2")){

            strCourseHeader = intent.getStringExtra(vowelCourse.EXTRA_COURSEHEADER);
            typeCourse = intent.getStringExtra(vowelCourse.EXTRA_TYPECOURSE);

        }


        morseAndAlpha = new MorseAndAlpha(strCourseHeader,typeCourse);


          arrayMorse = morseAndAlpha.checkMorse();
          arrayAlpha = morseAndAlpha.checkAlpha();


        // set Header text to activities
        courseHeader = findViewById(R.id.courseHeader);
        courseHeader.setText(strCourseHeader);

         lenArrayAlpha = arrayAlpha.length;  // len of array alpha

        // set text to view alpha and morse
        // checkCountCorrect is 0 because nothing correct

        if(checkCountCorrect==0){
            textViewAlpha.setText(arrayAlpha[checkCountCorrect]);
            textViewMorse.setText(arrayMorse[checkCountCorrect]);
        }


    }

    public void backToCourse(View view){
        onBackPressed();
    }

    public void dotClick(View view){

            sound.start();

        if(strMorse.equals("")){
            textViewMorseWrite.setText(".");
            strMorse ="-";
            checkCorrect(".");
            Log.d("dotClick ",strMorse+"1Null");
        }else{
            strMorse = textViewMorseWrite.getText().toString(); // get text from textViewMorseWrite
            strMorse = strMorse.concat("."); // concat string from TextView
            textViewMorseWrite.setText(strMorse); // get text to textViewMorseWrite
            checkCorrect(strMorse); // check answer from TextView
            Log.d("dotClick ",strMorse+"1");
        }




    } // end of dot click
    public void dashClick(View view){
        sound2.start();

        if(strMorse.equals("")){

            // if strMorse = "" and set text to MorseWrite and assign value to strMorse
            textViewMorseWrite.setText("-"); // set text to Morse write TextView
            strMorse="-";  // assign value to strMorse

            checkCorrect("-"); // check answer from TextView


        }else{
            // if strMorse != ""
            strMorse  = textViewMorseWrite.getText().toString(); // get text from textViewMorseWrite

            strMorse = strMorse.concat("-");  // concat string from TextView
            textViewMorseWrite.setText(strMorse); // set concat text to Morse write TextView
            checkCorrect(strMorse); // check answer from TextView

        }



    } // end of dat click

    public void finishLesson(final String text) {



        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.finish_course, null);
        TextView textView = view.findViewById(R.id.finishLessonText);

        builder.setView(view);
        textView.setText("คุณจบ"+text+" แล้ว");
        Button button = view.findViewById(R.id.nextLesson);

        final AlertDialog dialog = builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCountCorrect = 0;
                checkShowFinishLesson = 0;

                   checkNextLesson(typeCourse,text);

                    morseAndAlpha = new MorseAndAlpha(strCourseHeader,typeCourse);
                    String message = morseAndAlpha.checkStringAlpha();

                    Log.d("checkFinish",message);
                    switch(message){
                        case "จบคอร์สพยัญชนะ":
                                    builderItem.success(message);
                            break;
                        case "จบคอร์สสระ":
                                    builderItem.success(message);
                            break;
                        case "จบคอร์สวรรณยุกต์":
                                 builderItem.success(message);
                            break;
                        case "จบคอร์สเครื่องหมาย":
                                builderItem.success(message);
                            break;
                        case "จบคอร์สตัวเลข":
                                builderItem.success(message);
                            break;
                            default:
                                arrayAlpha = morseAndAlpha.checkAlpha();
                                arrayMorse = morseAndAlpha.checkMorse();
                                lenArrayAlpha = arrayAlpha.length;

                                alertSendToCourse(strCourseHeader,message);
                                courseHeader.setText(strCourseHeader);

                                Log.d("jame",checkCountCorrect+"");
                                Log.d("jame",lenArrayAlpha+" lenArrayAlpha");
                                textViewAlpha.setText(arrayAlpha[checkCountCorrect]);
                                textViewMorse.setText(arrayMorse[checkCountCorrect]);
                                break;
                    }

                dialog.dismiss();
            }
        });
        builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            //strCourseHeader
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        dialog.show();

    }  // end of finish Lesson

    int checkShowFinishLesson =0; // check if checkShowFinishLesson true and then will show alert finish lesson
    // check morse with answer from user
    public void checkCorrect(String answerStr){


        int lenMorse = arrayMorse[checkCountCorrect].length();

        Log.d("charAtLen",lenMorse+"");

        Log.d("charAt",checkCountCorrect+" checkCountCorrect");
        Log.d("charAt",arrayMorse[checkCountCorrect].charAt(checkCountMorse)+"  +++");
        Log.d("charAt",answerStr);

        if(answerStr.charAt(checkCountMorse) == arrayMorse[checkCountCorrect].charAt(checkCountMorse)){ // compare char between answer and arrMorse[checkCorrect] String
            checkCountMorse++;
            Log.d("charAt",checkCountMorse+" checkCountMorse");
            if(checkCountMorse==lenMorse){
                if(answerStr.equals(arrayMorse[checkCountCorrect])){

                    if(checkCountCorrect==lenArrayAlpha-1){
                        checkShowFinishLesson = lenArrayAlpha; // checkShowFinish Lesson if true will alert dialog to next lesson
                          checkCountCorrect = lenArrayAlpha-1;
                          finishLesson(strCourseHeader);
                      }else {
                          checkCountCorrect++;
                      }

                    // set time to show alert if answer correct

                       new CountDownTimer(500, 1000) {

                          @Override
                          public void onTick(long millisUntilFinished) {

                          }

                          @Override
                          public void onFinish() {

                              Log.d("jame",checkShowFinishLesson+" checkShowFinishLesson");
                              Log.d("jame",lenArrayAlpha+" lenArrayAlpha");

                              if(checkShowFinishLesson!=lenArrayAlpha){
                                  builderItem.correctBuilder();
                              }
                                  checkCountMorse=0;

                                  textViewMorse.setText(arrayMorse[checkCountCorrect]);
                                  textViewAlpha.setText(arrayAlpha[checkCountCorrect]);

                                  strMorse = "";
                                  textViewMorseWrite.setText(strMorse);

                          }
                      }.start(); // end of CountDownTimer
                } else{
                    // if answer not correct and setting the time to show alert incorrect
                      new CountDownTimer(500, 1000) {

                          @Override
                          public void onTick(long millisUntilFinished) {

                          }

                          @Override
                          public void onFinish() {
                              builderItem.incorrectBuilder();
                              builderItem.vibrate(v);
                              textViewMorse.setText(arrayMorse[checkCountCorrect]);
                              textViewAlpha.setText(arrayAlpha[checkCountCorrect]);

                              strMorse = "";
                              textViewMorseWrite.setText(strMorse);
                          }
                      }.start(); // end of CountDownTimer
                } // end of if compare for check answer morse
            } // end of if compare len morse
        }else{
            // "if else" if compare char answer and arrMorse String is false
           new CountDownTimer(500,1000){

               @Override
               public void onTick(long millisUntilFinished) {

               }

               @Override
               public void onFinish() {
                   checkCountMorse=0;
                   builderItem.incorrectBuilder();
                   builderItem.vibrate(v);
                   strMorse = "";
                   textViewMorseWrite.setText(strMorse);
               }
           }.start(); // end of CountDownTimer
        }  // end of compare char between answer and arrayMorse String

    } // end of method checkCorrect

    public void alertSendToCourse(String title,String message){
        dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", null)
                .show();
        positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

    } // end of alert dialog

public void checkNextLesson(String typeCourse,String text){

        if(typeCourse.equals("พยัญชนะ")){
            switch(text) {
                case "บทเรียนที่ 1": strCourseHeader = "บทเรียนที่ 1.1";
                    break;
                case "บทเรียนที่ 1.1": strCourseHeader = "บทเรียนที่ 2";
                    break;
                case "บทเรียนที่ 2": strCourseHeader = "บทเรียนที่ 2.1";
                    break;
                case "บทเรียนที่ 2.1": strCourseHeader = "บทเรียนที่ 2.2";
                    break;
                case "บทเรียนที่ 2.2": strCourseHeader = "บทเรียนที่ 2.3";
                    break;
                case "บทเรียนที่ 2.3": strCourseHeader = "บทเรียนที่ 2.4";
                    break;
                case "บทเรียนที่ 2.4": strCourseHeader = "บทเรียนที่ 2.5";
                    break;
                case "บทเรียนที่ 2.5": strCourseHeader = "บทเรียนที่ 3";
                    break;
                case "บทเรียนที่ 3": strCourseHeader = "บทเรียนที่ 3.1";
                    break;
                case "บทเรียนที่ 3.1": strCourseHeader = "บทเรียนที่ 4";
                    break;
                case "บทเรียนที่ 4": strCourseHeader = "บทเรียนที่ 4.1";
                    break;
                case "บทเรียนที่ 4.1": strCourseHeader = "บทเรียนที่ 5";
                    break;
                case "บทเรียนที่ 5": strCourseHeader = "บทเรียนที่ 6";
                    break;
                case "บทเรียนที่ 6": strCourseHeader = "จบคอร์สพยัญชนะ";
                    break;
            } // end of switch thai course
        }else if(typeCourse.equals("สระ")){
            switch(text) {
                case "บทเรียนที่ 1":
                    strCourseHeader = "บทเรียนที่ 2";
                    break;
                case "บทเรียนที่ 2":
                    strCourseHeader = "บทเรียนที่ 3";
                    break;
                case "บทเรียนที่ 3":
                    strCourseHeader = "บทเรียนที่ 4";
                    break;
                case "บทเรียนที่ 4":
                    strCourseHeader = "จบคอร์สสระ";
                    break;
            }
        }else if(typeCourse.equals("วรรณยุกต์")){
            switch(text) {
                case "บทเรียนที่ 1":
                    strCourseHeader = "จบคอร์สวรรณยุกต์";
                    break;
            }
        }else if(typeCourse.equals("เครื่องหมาย")){
            switch(text) {
                case "บทเรียนที่ 1": strCourseHeader = "บทเรียนที่ 2";
                    break;
                case "บทเรียนที่ 2": strCourseHeader = "บทเรียนที่ 3";
                    break;
                case "บทเรียนที่ 3": strCourseHeader = "บทเรียนที่ 4";
                    break;
                case "บทเรียนที่ 4": strCourseHeader = "บทเรียนที่ 5";
                    break;
                case "บทเรียนที่ 5": strCourseHeader = "บทเรียนที่ 6";
                    break;
                case "บทเรียนที่ 6": strCourseHeader = "บทเรียนที่ 7";
                    break;
                case "บทเรียนที่ 7": strCourseHeader =  "จบคอร์สเครื่องหมาย";
                    break;
            }
        }else if(typeCourse.equals("ตัวเลข")){
            switch(text) {
                case "บทเรียนที่ 1": strCourseHeader = "บทเรียนที่ 2";
                    break;
                case "บทเรียนที่ 2": strCourseHeader = "จบคอร์สตัวเลข";
                    break;
            }
        }
}

} // end of course class
