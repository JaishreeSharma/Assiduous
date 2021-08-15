package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    LinearLayout ll1,ll3,ll4,ll2;

    FirebaseAuth firebaseAuth;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        ll1=findViewById(R.id.layoutgoal);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Excercise.class));
            }
        });

        ll2=findViewById(R.id.layout2);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Reminder2.class));
            }
        });


        ll3=findViewById(R.id.layout3);
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Scan1.class));
            }
        });

        ll4=findViewById(R.id.layout4);
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Emergency.class));
            }
        });


        actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        firebaseAuth = FirebaseAuth.getInstance();


    }


    private void checkUserStatus(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user!=null){
            //mprofileT.setText(user.getEmail());
        }
        else {
            startActivity(new Intent(Dashboard.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {

        checkUserStatus();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout){
            firebaseAuth.signOut();
            checkUserStatus();
        }
        int id1 = item.getItemId();
        if (id1 == R.id.action_profile){
            startActivity(new Intent(Dashboard.this, Profile.class));
        }
        return super.onOptionsItemSelected(item);
    }
}