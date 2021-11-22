package com.example.servicesproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {                                                                        //initialize method or build service and this method call just once.
        super.onCreate();
        Log.d("service", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {                              //when we want call service , we use this method.
        Log.d("service", "onStartCommand");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                Log.d("service", "onStartCommand: work# " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);

    }


    @Override
    public void onDestroy() {                                                                       //when service doing its works and it's will destroying.
        super.onDestroy();
        Log.d("service", "onDestroy");

    }

}
