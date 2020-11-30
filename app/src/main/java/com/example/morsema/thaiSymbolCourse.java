package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thaiSymbolCourse extends AppCompatActivity implements View.OnClickListener{

    Button thaiSymbolCourse1,thaiSymbolCourse2,thaiSymbolCourse3,thaiSymbolCourse4,thaiSymbolCourse5,thaiSymbolCourse6,thaiSymbolCourse7,positiveButton;
    Intent intSendCourse;
    AlertDialog dialog;
    public final static String EXTRA_COURSEHEADER="ThaiCourseHeader";
    public final static String EXTRA_TYPECOURSE="ThaiTypeCourse";
    public final static String EXTRA_CHECKSEND="ThaicheckSend";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_symbol_course);
        Intent intent = getIntent();
        intSendCourse = new Intent(this,course.class);

        thaiSymbolCourse1 = findViewById(R.id.thaiSymbolCourse1);
        thaiSymbolCourse2 = findViewById(R.id.thaiSymbolCourse2);
        thaiSymbolCourse3 = findViewById(R.id.thaiSymbolCourse3);
        thaiSymbolCourse4 = findViewById(R.id.thaiSymbolCourse4);
        thaiSymbolCourse7 = findViewById(R.id.thaiSymbolCourse7);
        thaiSymbolCourse5 = findViewById(R.id.thaiSymbolCourse5);
        thaiSymbolCourse6 = findViewById(R.id.thaiSymbolCourse6);

    }

    public void backToThaiOption(View view){
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.thaiSymbolCourse1:

                sendDataToCourse("บทเรียนที่ 1",".\t\t &\t\t \"","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse2:
                sendDataToCourse("บทเรียนที่ 2","(\t\t)","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse3:
                sendDataToCourse("บทเรียนที่ 3",",\t\t:\t\t","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse4:
                sendDataToCourse("บทเรียนที่ 4","/\t\t=\t\t-","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse5:
                sendDataToCourse("บทเรียนที่ 5","?\t\t_","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse6:
                sendDataToCourse("บทเรียนที่ 6","!\t\t;","เครื่องหมาย");
                break;
            case R.id.thaiSymbolCourse7:
                sendDataToCourse("บทเรียนที่ 7","@\t\t$\t\t'\t\t","เครื่องหมาย");
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
                intSendCourse.putExtra(EXTRA_COURSEHEADER,title);
                intSendCourse.putExtra(EXTRA_TYPECOURSE,typeCourseSend);
                intSendCourse.putExtra("checkSend","1"); // 1 is thai course
                // show dialog of course
                startActivity(intSendCourse);
                dialog.dismiss();
            }
        });
    }
}
