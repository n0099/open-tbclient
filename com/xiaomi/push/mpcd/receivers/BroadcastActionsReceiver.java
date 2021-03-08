package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;
/* loaded from: classes5.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private dw f8476a;

    public BroadcastActionsReceiver(dw dwVar) {
        this.f8476a = dwVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f8476a != null) {
            this.f8476a.a(context, intent);
        }
    }
}
