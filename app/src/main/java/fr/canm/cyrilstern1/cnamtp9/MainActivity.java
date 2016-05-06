package fr.canm.cyrilstern1.cnamtp9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import fr.canm.cyrilstern1.cnamtp9.Receiver.SmsReceiver;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService;

public class MainActivity extends AppCompatActivity {
    private static final String smsFilter = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        SmsReceiver smsReceiver = new SmsReceiver();
        Log.i("passe","parla");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(smsFilter);
        intentFilter.setPriority(23456765);
        registerReceiver(smsReceiver,intentFilter);

    }
}
