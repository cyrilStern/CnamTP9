package fr.canm.cyrilstern1.cnamtp9.Receiver;

import android.app.Application;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import fr.canm.cyrilstern1.cnamtp9.MainActivity;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by cyrilstern1 on 06/05/2016.
 */
public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            if (bundle != null) {
                        //---retrieve the SMS message received---
                SmsMessage[] msgs = null;
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String msg_from = msgs[i].getOriginatingAddress();
                    String msgBody = msgs[i].getMessageBody();
                    Intent getservice = new Intent(context, SmsService.class);
                    getservice.putExtra("sms", msgBody);
                    context.startService(getservice);

            }

        }
    }
}
