package fr.canm.cyrilstern1.cnamtp9.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import fr.canm.cyrilstern1.cnamtp9.ChainHandler;
import fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService;
import fr.canm.cyrilstern1.cnamtp9.TraceHandler;

/**
 * Created by cyrilstern1 on 06/05/2016.
 */
public class SmsReceiver extends BroadcastReceiver {
    private ChainHandler<String> chaine;
    @Override
    public void onReceive(final Context context, Intent intent) {
        Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            if (bundle != null) {
                        //---retrieve the SMS message received---
                SmsMessage[] msgs = null;
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String msg_from = msgs[i].getOriginatingAddress();
                    final String msgBody = msgs[i].getMessageBody();
                    Log.i("ToastChainHandler",   " handleRequest: "  );
                    chaine=new TraceHandler(context,null);
                    chaine.handleRequest(msgBody);

//                    Intent intent1 = new Intent(context, SmsService.class);
//                    intent1.putExtra("sms",msgBody);
//                    context.startService(intent1);



            }

        }
    }
}
