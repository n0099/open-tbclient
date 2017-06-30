package com.xiaomi.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.network.d;
/* loaded from: classes2.dex */
public class NetworkStatusChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (d.f(context)) {
            try {
                context.startService(new Intent(context, HostRefreshService.class));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
