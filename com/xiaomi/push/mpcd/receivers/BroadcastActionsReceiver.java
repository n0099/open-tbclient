package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;
/* loaded from: classes18.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private dw f4783a;

    public BroadcastActionsReceiver(dw dwVar) {
        this.f4783a = dwVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f4783a != null) {
            this.f4783a.a(context, intent);
        }
    }
}
