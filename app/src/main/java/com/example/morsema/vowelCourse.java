package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vowelCourse extends AppCompatActivity {

    Button positiveButton;
    Intent intSendCourse;
    AlertDialog dialog;
    public final static String EXTRA_COURSEHEADER="vowelCourseHeader";
    public final static String EXTRA_TYPECOURSE="vowelCourse";
    public final static String EXTRA_CHECKSEND="ThaicheckSend";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowel_course);

        Intent intent = getIntent();
        intSendCourse = new Intent(this,course.class);
    }

    public void onClick(View v) {

        switch(v.getId()){
            case R.id.vowelCourse1:
                sendDataToCourse("บทเรียนที่ 1","เอ, อี,  อือ,  อึอ","สระ");
                break;
            case R.id.vowelCourse2:
                sendDataToCourse("บทเรียนที่ 2","อา, แอ, อะ, ไอ ใอ","สระ");
                break;
            case R.id.vowelCourse3:
                sendDataToCourse("บทเรียนที่ 3","โอ, อู","สระ");
                break;
            case R.id.vowelCourse4:
                sendDataToCourse("บทเรียนที่ 4","อำ","สระ");
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
        final String typeCouseSend = typeCourse;

        // function of show dialog
        alertSendToCourse(title,message);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent send data to course.java
                intSendCourse.putExtra(EXTRA_COURSEHEADER,title);
                intSendCourse.putExtra(EXTRA_TYPECOURSE,typeCouseSend);
                intSendCourse.putExtra("checkSend","2"); // 2 vowel

                // show dialog of course
                startActivity(intSendCourse);
                dialog.dismiss();
            }
        });
    }

    public void backToThaiOption(View view){
        onBackPressed();
    }
}
