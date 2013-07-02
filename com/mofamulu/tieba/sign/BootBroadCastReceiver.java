package com.mofamulu.tieba.sign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.mofamulu.tieba.ch.bg;
/* loaded from: classes.dex */
public class BootBroadCastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("tbhp_ss", "system booted. Auto start signService.");
        bg.c().m();
    }
}
