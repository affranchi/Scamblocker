package com.devest.scamblocker;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Kenneth Lee on 7/14/2015.
 */
public class PhoneStateReceiver extends PhoneStateListener{
    private String TAG = "PhoneStateReceiver";

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);
        switch(state)
        {
            case TelephonyManager.CALL_STATE_IDLE:
                Log.i(TAG, "PhoneStateReceiver->onCallStateChanged(): IDLE"
                            + incomingNumber);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.i(TAG, "PhoneStateReceiver->onCallStateChanged(): OFFHOOK"
                        + incomingNumber);
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Log.i(TAG, "PhoneStateReceiver->onCallStateChanged(): RINGING"
                        + incomingNumber);
                break;
            default:
                Log.i(TAG, "PhoneStateReceiver->onCallStateChanged(): default"
                        + incomingNumber);
                break;
        }
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);

        switch(serviceState.getState())
        {
            case ServiceState.STATE_IN_SERVICE:
                Log.i(TAG, "PhoneStateReceiver->onServiceStateChanged() : STATE_IN_SERVICE");
                serviceState.setState(ServiceState.STATE_IN_SERVICE);
                break;
            case ServiceState.STATE_OUT_OF_SERVICE:
                Log.i(TAG, "PhoneStateReceiver->onServiceStateChanged() : STATE_OUT_OF_SERVICE");
                serviceState.setState(ServiceState.STATE_OUT_OF_SERVICE);
                break;
            case ServiceState.STATE_EMERGENCY_ONLY:
                Log.i(TAG, "PhoneStateReceiver->onServiceStateChanged() : STATE_EMERGENCY_ONLY");
                serviceState.setState(ServiceState.STATE_EMERGENCY_ONLY);
                break;
            case ServiceState.STATE_POWER_OFF:
                Log.i(TAG, "PhoneStateReceiver->onServiceStateChanged() : STATE_POWER_OFF");
                serviceState.setState(ServiceState.STATE_POWER_OFF);
                break;
            default:
                Log.i(TAG, "PhoneStateReceiver->onServiceStateChanged() : default " + Integer.toString( serviceState.getState() ) );
                serviceState.setState(ServiceState.STATE_IN_SERVICE);
                break;
        }
    }
}
