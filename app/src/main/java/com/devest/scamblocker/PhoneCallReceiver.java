package com.devest.scamblocker;

/**
 * Created by Kenneth Lee on 7/14/2015.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Method;

public class PhoneCallReceiver extends BroadcastReceiver{
    private String TAG = "PhoneCallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "PhoneCallReceiver->onReceive()");
        PhoneStateReceiver stateReceiver = new PhoneStateReceiver();
        TelephonyManager telMgr = (TelephonyManager) context.getSystemService( context.TELEPHONY_SERVICE);
        Log.i(TAG, "HANG UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!00000000000");
        try {
            Class c = Class.forName(telMgr.getClass().getName());
            Method m = c.getDeclaredMethod("getITelephony");
            m.setAccessible(true);
            ITelephony telephonyService = (ITelephony) m.invoke(telMgr);
            telephonyService.endCall();
            Log.i(TAG, "HANG UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11111111111");
        }
        catch(Exception e)
        {
            Log.i(TAG, "HANG UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!222222222222");
        }

        telMgr.listen(stateReceiver, stateReceiver.LISTEN_SERVICE_STATE);

            Intent mainActivity = new Intent( context, CallCatcher.class);
            mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mainActivity.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);

        context.startActivity(mainActivity);
    }
}
