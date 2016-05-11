package fr.canm.cyrilstern1.cnamtp9.SmsService;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import fr.canm.cyrilstern1.cnamtp9.Receiver.SmsReceiver;
import fr.canm.cyrilstern1.cnamtp9.SmsAIDL;


public class SmsService2 extends Service {
    private static final String smsFilter = "android.provider.Telephony.SMS_RECEIVED";

    @Override
        public void onCreate() {
            super.onCreate();
        IntentFilter intentAction = new IntentFilter();
        intentAction.addAction("service.conection");
        }

        @Override
        public IBinder onBind(Intent intent) {
            // Return the interface
            return smsAIDL;
        }
    private SmsReceiver smsReceiver;


    SmsAIDL.Stub smsAIDL = new SmsAIDL.Stub() {
        @Override
        public void startSMSInterceptor() throws RemoteException {
            Log.i("place","passe par la");
            smsReceiver = new SmsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(smsFilter);
            intentFilter.setPriority(23456765);
            registerReceiver(smsReceiver,intentFilter);


        }

        @Override
        public void stopSMSInterceptor() throws RemoteException {

        }

        @Override
        public long interceptedSMS() throws RemoteException {
            Toast.makeText(getApplicationContext(),"nfcjkncjcnezjck: ",Toast.LENGTH_LONG).show();
            Log.i("fresf","freshhhhhh");

            return 0;
        }

        @Override
        public String lastSMSReceived() throws RemoteException {
            return null;
        }

        @Override
        public String lastSMSIntercepted() throws RemoteException {
            return null;
        }
    };



    }

