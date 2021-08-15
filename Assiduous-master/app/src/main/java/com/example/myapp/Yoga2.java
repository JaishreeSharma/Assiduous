package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Yoga2 extends AppCompatActivity {
    TextView timer,intropage,btnexercise,fitdes,fittitle;
    View bgprogress;
    LinearLayout fittone;
    ImageView imagetimer;

    Animation btthree,bttfour,ttbone,ttbtwo,alpha;

    private static final long START_TIME_IN_MILlIS=120000;
    public CountDownTimer countDownTimer;
    public boolean mTimerRunning;
    private long mTimerLeftInMillis = START_TIME_IN_MILlIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga2);
        ttbone= AnimationUtils.loadAnimation(this,R.anim.ttbone);
        btthree=AnimationUtils.loadAnimation(this,R.anim.btthree);
        bttfour=AnimationUtils.loadAnimation(this,R.anim.bttfour);
        ttbtwo=AnimationUtils.loadAnimation(this,R.anim.ttbtwo);
        alpha=AnimationUtils.loadAnimation(this,R.anim.alpha);

        timer=findViewById(R.id.timerValue);
        intropage=findViewById(R.id.intropage);
        fittitle=findViewById(R.id.fittitle);
        fitdes=findViewById(R.id.fitdes);
        btnexercise=findViewById(R.id.btnexercise);
        bgprogress=findViewById(R.id.bgprogress);

        fittone=findViewById(R.id.fitone);
        imagetimer=findViewById(R.id.imgtimer);

        btnexercise.startAnimation(bttfour);
        intropage.startAnimation(ttbtwo);
        bgprogress.startAnimation(btthree);
        fittone.startAnimation(ttbone);
        timer.startAnimation(alpha);
        imagetimer.startAnimation(alpha);

        startTimer();

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Yoga2.this,Yoga3.class);
                startActivity(intent);
            }
        });

    }
    private void startTimer(){
        countDownTimer=new CountDownTimer(mTimerLeftInMillis,1000) {
            @Override
            public void onTick(long milesUntilFinished) {
                mTimerLeftInMillis =milesUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"DONE!",Toast.LENGTH_SHORT).show();

            }
        }.start();
        mTimerRunning=true;
    }

    private void updateCountDownText(){
        int minutes=(int)(mTimerLeftInMillis / 1000) / 60;
        int seconds=(int)(mTimerLeftInMillis / 1000) % 60;

        String timeLeft=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timer.setText(timeLeft);

    }
}