package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scan1 extends AppCompatActivity implements View.OnClickListener {
    Button scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan1);


        scan_btn = findViewById(R.id.scan_btn);
        scan_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        scanCode();

    }

    private void scanCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData data = ClipData.newPlainText("result", result.getContents());
                        manager.setPrimaryClip(data);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }

                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
            else{
                Toast.makeText(this, "No Results", Toast.LENGTH_LONG).show();
            }
        }else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}