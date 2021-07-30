package com.prabhakar.sendbroadcastwithintheapp;

import android.content.Context;
import android.content.Intent;

public class LocalBroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String getMessage = intent.getStringExtra("msg");
            Intent sendIntent = new Intent(context, BroadcastReceiverActivity.class);
            sendIntent.putExtra("msg", getMessage);
            context.startActivity(sendIntent);
        }
    }
}
