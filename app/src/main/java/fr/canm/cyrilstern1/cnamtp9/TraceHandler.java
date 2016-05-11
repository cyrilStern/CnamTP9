package fr.canm.cyrilstern1.cnamtp9;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by cyrilstern1 on 06/05/2016.
 */
public class TraceHandler extends ChainHandler<String> {
    private final static boolean I = true;

    private Context context;

    public TraceHandler(Context context, ChainHandler<String> successor){
        super(successor);
        this.context = context;
        Log.i("pass","çamere");
    }

    public boolean handleRequest(String value){

        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        DateFormat dt = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);
        String date = df.format(c.getTime()) + "-" + dt.format(c.getTime());
        Log.i("ToastChainHandler", date + " handleRequest: " + value );

        Toast.makeText(context, "receiving  sms", Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"value: " + value,Toast.LENGTH_LONG).show();
        //if(I) Log.i("ToastChainHandler","handleRequest: " + value );
        return super.handleRequest(value);
    }
}