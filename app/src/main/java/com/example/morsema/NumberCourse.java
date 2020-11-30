package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NumberCourse extends AppCompatActivity implements View.OnClickListener{

    Button numberCourse1,numberCourse2,positiveButton;
    AlertDialog dialog;
    Intent intent;
    public final static String EXTRA_COURSEHEADER="ThaiCourseHeader";
    public final static String EXTRA_TYPECOURSE="ThaiTypeCourse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_course);
        intent = getIntent();
        intent = new Intent(this,course.class);
    }
    public void backToThaiOption(View view){
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.numberCourse1:

                sendDataToCourse("บทเรียนที่ 1","1, 2, 3, 4, 5","ตัวเลข");
                break;
            case R.id.numberCourse2:
                sendDataToCourse("บทเรียนที่ 2","6, 7, 8, 9, 0","ตัวเลข");
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
