package fr.canm.cyrilstern1.cnamtp9;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import fr.canm.cyrilstern1.cnamtp9.Receiver.SmsReceiver;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService2;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsServiceFirst;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){

        startService(new Intent(this,SmsService2.class));


    }

    public void startService(View view){
        Toast.makeText(this, "service start", Toast.LENGTH_SHORT).show();
        Intent startServiceI = new Intent(this, SmsServiceFirst.class);
        startService(startServiceI);

    }
    public void stopService(View view){
        Toast.makeText(this, "service stop", Toast.LENGTH_SHORT).show();
        Intent stopServicei = new Intent(this,SmsServiceFirst.class);
        stopService(stopServicei);

    }

}
