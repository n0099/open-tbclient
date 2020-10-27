package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;
/* loaded from: classes12.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private dw f5011a;

    public BroadcastActionsReceiver(dw dwVar) {
        this.f5011a = dwVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f5011a != null) {
            this.f5011a.a(context, intent);
        }
    }
}
