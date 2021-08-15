package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Workout extends AppCompatActivity {

    TextView titlepage,subtitlepage,btnexercise,subintro,intro,fit1,des1,fit2,des2,fit3,des3,fit4,des4,fit5,des5,fit6,des6;
    Animation bttone,bttwo,bttfour,bttfive,bttsix,bttseven,btteight;
    View bgprogress,bgprogresstop;
    LinearLayout fittone,fittone1,fittone2,fittone3,fittone4,fittone5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        bttone= AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo=AnimationUtils.loadAnimation(this,R.anim.bttwo);
        bttfour=AnimationUtils.loadAnimation(this,R.anim.bttfour);
        bttfive=AnimationUtils.loadAnimation(this,R.anim.bttfive);
        bttsix=AnimationUtils.loadAnimation(this,R.anim.bttsix);
        bttseven=AnimationUtils.loadAnimation(this,R.anim.bttseven);
        btteight=AnimationUtils.loadAnimation(this,R.anim.btteight);


        btnexercise=findViewById(R.id.btnexercise);
        titlepage=findViewById(R.id.titlepage);
        subtitlepage=findViewById(R.id.subtitlepage);
        intro=findViewById(R.id.intropage );
        subintro=findViewById(R.id.subintro);
        fit1=findViewById(R.id.fittitle);
        des1=findViewById(R.id.fitdes);
        fit2=findViewById(R.id.fittitle1);
        des2=findViewById(R.id.fitdes1);
        fit3=findViewById(R.id.fittitle2);
        des3=findViewById(R.id.fitdes2);
        fit4=findViewById(R.id.fittitle3);
        des4=findViewById(R.id.fitdes3);
        fit5=findViewById(R.id.fittitle4);
        des5=findViewById(R.id.fitdes4);
        fit6=findViewById(R.id.fittitle5);
        des6=findViewById(R.id.fitdes5);

        bgprogress=findViewById(R.id.bgprogress);
        bgprogresstop=findViewById(R.id.bgprogresstop);

        fittone=findViewById(R.id.fitone);
        fittone1=findViewById(R.id.fitone1);
        fittone2=findViewById(R.id.fitone2);
        fittone3=findViewById(R.id.fitone3);
        fittone4=findViewById(R.id.fitone4);
        fittone5=findViewById(R.id.fitone5);

        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        intro.startAnimation(bttwo);
        subintro.startAnimation(bttwo);

        fittone.startAnimation(bttwo);
        fittone1.startAnimation(bttfour);
        fittone2.startAnimation(bttfive);
        fittone3.startAnimation(bttsix);
        fittone4.startAnimation(bttfour);
        fittone5.startAnimation(bttsix);

        btnexercise.startAnimation(btteight);
        bgprogress.startAnimation(bttseven);


        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Workout.this,StartWorkout.class);
                startActivity(intent);
            }
        });
    }
}