package com.example.morsema;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class thaiCourse extends AppCompatActivity implements View.OnClickListener{

    Button thaiCourse1,thaiCourse1_1,thaiCourse2,thaiCourse2_1,thaiCourse2_2,thaiCourse2_3,thaiCourse2_4,thaiCourse2_5,
            thaiCourse3_1,thaiCourse3,thaiCourse4,thaiCourse4_1,thaiCourse5,thaiCourse6,positiveButton;
    Intent intSendCourse;
    AlertDialog dialog;
    public final static String EXTRA_COURSEHEADER="ThaiCourseHeader";
    public final static String EXTRA_TYPECOURSE="ThaiTypeCourse";
    public final static String EXTRA_CHECKSEND="ThaicheckSend";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_course);
        Intent intent = getIntent();
        intSendCourse = new Intent(this,course.class);

        thaiCourse1 = findViewById(R.id.thaiCourse1);
        thaiCourse1_1 = findViewById(R.id.thaiCourse1_1);
        thaiCourse2 = findViewById(R.id.thaiCourse2);
        thaiCourse2_1 = findViewById(R.id.thaiCourse2_1);
        thaiCourse2_2 = findViewById(R.id.thaiCourse2_2);
        thaiCourse2_3 = findViewById(R.id.thaiCourse2_3);
        thaiCourse2_4 = findViewById(R.id.thaiCourse2_4);
        thaiCourse2_5 = findViewById(R.id.thaiCourse2_5);
        thaiCourse3 = findViewById(R.id.thaiCourse3);
        thaiCourse3_1 = findViewById(R.id.thaiCourse3_1);
        thaiCourse4 = findViewById(R.id.thaiCourse4);
        thaiCourse4_1 = findViewById(R.id.thaiCourse4_1);
        thaiCourse5 = findViewById(R.id.thaiCourse5);
        thaiCourse6 = findViewById(R.id.thaiCourse6);

    }

    public void backToThaiOption(View view){
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.thaiCourse1:

                sendDataToCourse("บทเรียนที่ 1","ต ฏ, ม, ก, ผ, ฮ","พยัญชนะ");
                break;
            case R.id.thaiCourse1_1:
                sendDataToCourse("บทเรียนที่ 1.1","ต ฏ, ม, ก, ซ","พยัญชนะ");
                break;
            case R.id.thaiCourse2:
                sendDataToCourse("บทเรียนที่ 2","น ณ, ค ต ฆ, ข ฃ, ถ ฐ","พยัญชนะ");
                break;
            case R.id.thaiCourse2_1:
                sendDataToCourse("บทเรียนที่ 2.1","น ณ, ค ต ฆ, ข ฃ, ฝ","พยัญชนะ");
                break;
            case R.id.thaiCourse2_2:
                sendDataToCourse("บทเรียนที่ 2.2","น ณ, ค ต ฆ, ย, ง","พยัญชนะ");
                break;
            case R.id.thaiCourse2_3:
                sendDataToCourse("บทเรียนที่ 2.3","น ณ, ด ฎ, บ, อ","พยัญชนะ");
                break;
            case R.id.thaiCourse2_4:
                sendDataToCourse("บทเรียนที่ 2.4","น ณ, ด ฎ, ช ฌ, จ","พยัญชนะ");
                break;
            case R.id.thaiCourse2_5:
                sendDataToCourse("บทเรียนที่ 2.5","น ณ, ด ฎ, ช ฌ, ท ธ ฑ ฒ","พยัญชนะ");
                break;
            case R.id.thaiCourse3:
                sendDataToCourse("บทเรียนที่ 3","ว, ป, พ ภ","พยัญชนะ");
                break;
            case R.id.thaiCourse3_1:
                sendDataToCourse("บทเรียนที่ 3.1","ว, ญ","พยัญชนะ");
                break;
            case R.id.thaiCourse4:
                sendDataToCourse("บทเรียนที่ 4","ร, ล ฬ","พยัญชนะ");
                break;
            case R.id.thaiCourse4_1:
                sendDataToCourse("บทเรียนที่ 4.1","ร, ฤ ฤๅ","พยัญชนะ");
                break;
            case R.id.thaiCourse5:
                sendDataToCourse("บทเรียนที่ 5","ฟ","พยัญชนะ");
                break;
            case R.id.thaiCourse6:
                sendDataToCourse("บทเรียนที่ 6","ศ ษ ส, ห, ฉ","พยัญชนะ");
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
