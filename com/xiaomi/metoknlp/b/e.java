package com.xiaomi.metoknlp.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
/* loaded from: classes3.dex */
class e extends BroadcastReceiver {
    final /* synthetic */ c a;

    private e(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        NetworkInfo networkInfo;
        if (intent == null || (action = intent.getAction()) == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE") || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
            return;
        }
        if (networkInfo.isConnected()) {
            c.b(this.a).obtainMessage(200, networkInfo).sendToTarget();
        } else if (networkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
            c.b(this.a).obtainMessage(201, networkInfo).sendToTarget();
        }
    }
}
