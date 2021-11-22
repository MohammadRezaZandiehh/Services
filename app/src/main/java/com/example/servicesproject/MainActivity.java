package com.example.servicesproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartService = findViewById(R.id.buttonStart);
        Button buttonStopService = findViewById(R.id.buttonStop);
        TextView textViewCounter = findViewById(R.id.textViewCounter);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {                                 //when send each message , this method is called.
                Toast.makeText(context, "done!", Toast.LENGTH_SHORT).show();
            }
        };
        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("key", "sendEventFromActivity");
                startService(intent);
            }
        });


        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

//register
    @Override
    protected void onResume() {                                                                     //last method that run and activity launch. so user can see activity after this method.
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.example.action.service");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

//unRegister
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
}