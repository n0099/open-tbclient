package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
class bg extends BroadcastReceiver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean a;
        if (intent.getAction().equals("com.xiaomi.metok.geofencing.state_change")) {
            String stringExtra = intent.getStringExtra("Location");
            String stringExtra2 = intent.getStringExtra("Describe");
            String stringExtra3 = intent.getStringExtra("State");
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            a = this.a.a(stringExtra3, stringExtra2, context);
            if (!a) {
                stringExtra3 = "Unknown";
                com.xiaomi.channel.commonutils.logger.b.a(" updated geofence statue about geo_id:" + stringExtra2 + " falied. current_statue:Unknown");
            }
            com.xiaomi.smack.util.e.a(new bh(this, context, stringExtra2, stringExtra3));
            com.xiaomi.channel.commonutils.logger.b.c("ownresilt结果:state= " + stringExtra3 + "\n describe=" + stringExtra2 + "\n location=" + stringExtra);
        }
    }
}
