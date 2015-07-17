/**
 * Created by Kenneth Lee on 7/16/2015.
 */
package com.android.internal.telephony;

public interface ITelephony {
    boolean endCall();
    void answerRingingCall();
    void silenceRinger();
}
