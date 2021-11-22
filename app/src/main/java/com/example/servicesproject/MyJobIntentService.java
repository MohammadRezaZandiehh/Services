package com.example.servicesproject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class MyJobIntentService extends JobIntentService {


    public static void setWorker(Context context, Intent i) {
        enqueueWork(context, MyJobIntentService.class, 10, i);                                 // har bar kari behesh bedim vasamon too saf mindaze .
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Series started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        for (int i = 1; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("tagx", "onHandleIntent: service is done! ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
    }
}
