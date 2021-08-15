package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {

    DataBaseHelper myDB;
    Button btnAdd,btnView,btnNext;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        btnAdd=findViewById(R.id.btnAdd);
        btnView=findViewById(R.id.btnView);
        btnNext=findViewById(R.id.btnNext);
        editText=findViewById(R.id.editText);
        myDB=new DataBaseHelper(this);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Emergency.this,MapsActivity.class);
                startActivity(intent);
            }
        });



        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Emergency.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry=editText.getText().toString();
                if (editText.length() !=0 ){
                    AddData(newEntry);
                    editText.setText("");
                }
                else {
                    Toast.makeText(Emergency.this,"PLEASE ENTER THE NUMBER",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void AddData(String newEntry){
        boolean insertData=myDB.addData(newEntry);
        if (insertData==true){
            Toast.makeText(Emergency.this,"CONTACT ADDED",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(Emergency.this,"SOMETHING IS WRONG",Toast.LENGTH_LONG).show();
        }
    }
}