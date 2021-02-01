package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dw;
/* loaded from: classes6.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private dw f14190a;

    public BroadcastActionsReceiver(dw dwVar) {
        this.f14190a = dwVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f14190a != null) {
            this.f14190a.a(context, intent);
        }
    }
}
