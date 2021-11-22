package com.example.servicesproject;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "onCreate: " + Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {                                        //when we call this service , this method is called
        String username = intent.getExtras().getString("key");

        Log.d("service", "onHandleIntent: " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Log.d("service", "work: #" + i + " " + Thread.currentThread().getName());
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }                                                                                           //this block : get and put data from service.
        Intent localIntent = new Intent("com.example.action.service");
        localIntent.putExtra("key", true);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);                         //LocalBroadcastManager: send message to all local component in my app
    }                                                                                               // 3 khate bala : jaavbe service baraye view moon.

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service", "onDestroy: " + Thread.currentThread().getName());

    }
}
