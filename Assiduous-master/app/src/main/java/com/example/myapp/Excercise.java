package com.example.myapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Excercise extends AppCompatActivity {
    TextView titlepage,subtitlepage,btnexercise;
    ImageView impage;
    Animation animimgpage,bttone,btthree,lefttoright,bttwo;
    View bgprogress,bgprogresstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);

        animimgpage= AnimationUtils.loadAnimation(this,R.anim.animimpage);
        bttone= AnimationUtils.loadAnimation(this,R.anim.bttone);
        btthree= AnimationUtils.loadAnimation(this,R.anim.btthree);
        lefttoright= AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        bttwo=AnimationUtils.loadAnimation(this,R.anim.bttwo);


        btnexercise=findViewById(R.id.btnexercise);
        titlepage=findViewById(R.id.titlepage);
        subtitlepage=findViewById(R.id.subtitlepage);
        impage=findViewById(R.id.impage);
        bgprogress=findViewById(R.id.bgprogress);
        bgprogresstop=findViewById(R.id.bgprogresstop);


        impage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
        bgprogresstop.startAnimation(lefttoright);



        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Excercise.this,Options.class);
                startActivity(intent);
            }
        });
    }


}