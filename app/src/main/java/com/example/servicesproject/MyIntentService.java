package com.example.servicesproject;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

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
        Log.d("service", "onHandleIntent: " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Log.d("service", "work: #" + i + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service", "onDestroy: " + Thread.currentThread().getName());

    }
}
