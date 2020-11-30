package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class toneMarkCourse extends AppCompatActivity implements View.OnClickListener {

    Button toneMarkCourse1,positiveButton;



        AlertDialog dialog;
    Intent intent;
        public final static String EXTRA_COURSEHEADER="ThaiCourseHeader";
        public final static String EXTRA_TYPECOURSE="ThaiTypeCourse";
        public final static String EXTRA_CHECKSEND="ThaicheckSend";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tone_mark_course);
            intent = getIntent();
            intent = new Intent(this,course.class);

            toneMarkCourse1  = findViewById(R.id.toneMarkCourse1);

        }

        public void backToThaiOption(View view){
            onBackPressed();
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.toneMarkCourse1:

                    sendDataToCourse("บทเรียนที่ 1","ไม้เอก, ไม้โท, ไม้ตรี, ไม้จัตวา ","วรรณยุกต์");
                    break;

            }
        }

        // dialog method
        public void alertSendToCourse(String title,String message){
            dialog = new AlertDialog.Builder(this)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("Ok", null)
                    .show();
            positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        }

        public void sendDataToCourse(String lesson,String detail,String typeCourse){

            final String title = lesson;
            String message = detail;
            final String typeCourseSend = typeCourse;
            // function of show dialog
            alertSendToCourse(title,message);

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Intent send data to course.java
                    intent.putExtra(EXTRA_COURSEHEADER,title);
                    intent.putExtra(EXTRA_TYPECOURSE,typeCourseSend);
                    intent.putExtra("checkSend","1"); // 1 is thai course
                    // show dialog of course
                    startActivity(intent);
                    dialog.dismiss();
                }
            });
        }
    }


