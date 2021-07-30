package com.prabhakar.sendbroadcastwithintheapp;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 101;
    ;
    private Button sendBroadcastButton;
    //   private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcastReceiver localBroadcastReceiver;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //     localBroadcastManager = LocalBroadcastManager.getInstance(this);
        sendBroadcastButton = findViewById(R.id.sendBtn);
        sendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("ACTION.Private_Action");
                intent.putExtra("msg", "Hey, I am From Activity_Main");
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
                sendBroadcast(intent, Manifest.permission.CAMERA);

            }
        });
        broadcastReceiver();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Camera Permission is granted.", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    Toast.makeText(MainActivity.this, "Camera Permission is denied", Toast.LENGTH_SHORT).show();
                }
        }

    }

    private void broadcastReceiver() {
        localBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("ACTION.Private_Action");
        registerReceiver(localBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(localBroadcastReceiver);
    }
}