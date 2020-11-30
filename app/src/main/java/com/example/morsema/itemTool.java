package com.example.morsema;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;

import org.w3c.dom.Text;

import java.util.Map;
import java.util.ResourceBundle;


public class itemTool extends Activity {


    Context context;

    public final static String EXTRA_COURSEHEADER="ThaiCourseHeader";
    public itemTool(Context context) {
        this.context = context;

    }

    public void correctBuilder() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.correct_imageview, null);
        builder.setView(view);
        builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            //strCourseHeader
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        final AlertDialog alert = builder.create();
        alert.show();

        // Hide after some seconds
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };


        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 800);

    }  // end of correctBuilder

    public void incorrectBuilder() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.incorrect_imageview, null);
        builder.setView(view);
        builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            //strCourseHeader
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        final AlertDialog alert = builder.create();
        alert.show();

        // Hide after some seconds
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };


        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 800);

    }  // end of incorrectBuilder

    public void success(final String text) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View view = LayoutInflater.from(context).inflate(R.layout.success, null);
        TextView textView = view.findViewById(R.id.successText);
        textView.setText(text);
        builder.setView(view);

        builder.setPositiveButton("   ตกลง   ", new DialogInterface.OnClickListener() {
            //strCourseHeader
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent;
                if(text.equals("จบคอร์สตัวเลข")){
                    intent = new Intent(builder.getContext(), MainActivity.class);
                }else{
                    intent = new Intent(builder.getContext(), thaiOption.class);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                builder.getContext().startActivity(intent);
            }
        });

        final AlertDialog dialog = builder.create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onShow(DialogInterface arg0) {
              //  dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(Color.parseColor("#EC3F68"));
                Resources resource = builder.getContext().getResources(); // get resource
                Drawable drawable = ResourcesCompat.getDrawable(resource,R.drawable.button_pink,null); // tell get resource for drawable
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundDrawable(drawable);
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#FFFFFF"));

            }
        });

        dialog.show();

    }  // end of success



    public void vibrate(Vibrator v){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            v.vibrate(500);
        }

    }
}
