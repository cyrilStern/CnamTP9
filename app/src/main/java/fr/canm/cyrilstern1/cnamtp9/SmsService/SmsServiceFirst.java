package fr.canm.cyrilstern1.cnamtp9.SmsService;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import fr.canm.cyrilstern1.cnamtp9.R;
import fr.canm.cyrilstern1.cnamtp9.Receiver.SmsReceiver;

public class SmsServiceFirst extends Service {
    public SmsServiceFirst() {
    }
    private static final String smsFilter = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onCreate() {



    }
    private SmsReceiver smsReceiver;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        smsReceiver = new SmsReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(smsFilter);
        intentFilter.setPriority(23456765);
        registerReceiver(smsReceiver,intentFilter);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        if(smsReceiver != null)  unregisterReceiver(smsReceiver);

        Toast.makeText(this, "service sms stop", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }





}
