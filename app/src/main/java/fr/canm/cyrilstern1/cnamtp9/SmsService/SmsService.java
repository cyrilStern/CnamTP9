package fr.canm.cyrilstern1.cnamtp9.SmsService;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import fr.canm.cyrilstern1.cnamtp9.ChainHandler;
import fr.canm.cyrilstern1.cnamtp9.MainActivity;
import fr.canm.cyrilstern1.cnamtp9.TraceHandler;

/**
 * Created by cyrilstern1 on 06/05/2016.
 */
public class SmsService extends IntentService {
    public SmsService() {
        super("SmsService");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("çamere","camere");
    }

     private ChainHandler<String> chaine;

    @Override
    protected void onHandleIntent(Intent intent) {
        //http://stackoverflow.com/questions/7089313/android-listen-for-incoming-sms-messages
        String sms = intent.getStringExtra("sms");
        chaine=new TraceHandler(getApplicationContext(),null);
        chaine.handleRequest(sms);

    }

}
