package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tips extends AppCompatActivity {
    TextView titlepage,subtitlepage,btnexercise,subintro,intro,fit1,fit2,fit3;
    Animation bttone,bttwo,bttfour,bttfive,bttsix,bttseven,btteight;
    View bgprogress,bgprogresstop;
    LinearLayout fittone,fittone1,fittone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

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

        fit2=findViewById(R.id.fittitle1);
        fit3=findViewById(R.id.fittitle2);


        bgprogress=findViewById(R.id.bgprogress);
        bgprogresstop=findViewById(R.id.bgprogresstop);

        fittone=findViewById(R.id.fitone);
        fittone1=findViewById(R.id.fitone1);
        fittone2=findViewById(R.id.fitone2);


        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        intro.startAnimation(bttwo);
        subintro.startAnimation(bttwo);

        fittone.startAnimation(bttwo);
        fittone1.startAnimation(bttfour);
        fittone2.startAnimation(bttfive);


        btnexercise.startAnimation(btteight);
        bgprogress.startAnimation(bttseven);


        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Options.class);
                startActivity(intent);
            }
        });
        fittone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Tips1.class);
                startActivity(intent);
            }
        });
        fittone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Tips2.class);
                startActivity(intent);
            }
        });
        fittone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Tips3.class);
                startActivity(intent);
            }
        });
    }
}