package com.example.ekaratrattagan.mysms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsListener extends BroadcastReceiver{

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){

            SmsMessage[] msgs = new SmsMessage[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            }

            SmsMessage smsMessage = msgs[0];
            String msgBody = smsMessage.getMessageBody();

            Intent intentToActivity = new Intent(context, MainActivity.class);
            intentToActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentToActivity.putExtra("message", msgBody);
            context.startActivity(intentToActivity);


            //---get the SMS message passed in---
            /*Bundle bundle = intent.getExtras();
            SmsMessage[] msgs = null;
            String msg_from;

            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();

                        Intent intentToActivity = new Intent(context, MainActivity.class);
                        intentToActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intentToActivity.putExtra("message", msgBody);
                        context.startActivity(intentToActivity);
                    }
                }catch(Exception e){
                            Log.d("Exception caught",e.getMessage());
                }
            } */

        }
    }
}
