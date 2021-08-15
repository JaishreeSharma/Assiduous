package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.Adapter.EventAdapter;
import com.example.myapp.Database.DatabaseClass;
import com.example.myapp.Database.EntityClass;

import java.util.List;

public class Reminder2 extends AppCompatActivity implements View.OnClickListener {
    Button addMed;
    EventAdapter eventAdapter;
    RecyclerView recyclerView;
    DatabaseClass databaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder2);
        addMed = findViewById(R.id.btn_add_med);
        recyclerView = findViewById(R.id.recyclerview);
        addMed.setOnClickListener(this);
        databaseClass = DatabaseClass.getDatabase(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAdapter();
    }

    private void setAdapter(){
        List<EntityClass> classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getApplicationContext(),classList);
        recyclerView.setAdapter(eventAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == addMed){
            goToAddMedActivity();

        }
    }
    private void goToAddMedActivity(){
        Intent intent = new Intent(getApplicationContext(), AddMedActivity.class);
        startActivity(intent);


    }
}