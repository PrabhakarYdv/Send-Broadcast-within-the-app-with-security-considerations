package com.prabhakar.sendbroadcastwithintheapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BroadcastReceiverActivity extends AppCompatActivity {
    private TextView message;
    LocalBroadcastReceiver localBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        message = findViewById(R.id.message);
        message.setText(getIntent().getStringExtra("msg"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadcastReceiver);
    }
}