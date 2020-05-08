package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;
/* loaded from: classes8.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {
    private dw a;

    public BroadcastActionsReceiver(dw dwVar) {
        this.a = dwVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.a != null) {
            this.a.a(context, intent);
        }
    }
}
