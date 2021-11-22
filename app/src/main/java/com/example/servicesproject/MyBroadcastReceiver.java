package com.example.servicesproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent intentService = new Intent(context, MyJobIntentService.class);
            MyJobIntentService.setWorker(context, intentService);

//            context.startService(intentService);
        }
    }
}
