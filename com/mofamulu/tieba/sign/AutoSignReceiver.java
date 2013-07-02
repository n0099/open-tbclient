package com.mofamulu.tieba.sign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mofamulu.tieba.ch.bg;
/* loaded from: classes.dex */
public class AutoSignReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Intent intent2 = new Intent(context, SignService.class);
            intent2.putExtra("start_for_auto_sign", true);
            context.startService(intent2);
            bg.c().a(context);
        } catch (Throwable th) {
            bg.c().a(context);
        }
    }
}
