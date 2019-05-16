package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes3.dex */
class bx extends BroadcastReceiver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean a;
        if (TextUtils.equals("com.xiaomi.metoknlp.geofencing.state_change_protected", intent.getAction())) {
            String stringExtra = intent.getStringExtra("Describe");
            String stringExtra2 = intent.getStringExtra("State");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a = this.a.a(stringExtra2, stringExtra, context);
            if (!a) {
                stringExtra2 = "Unknown";
                com.xiaomi.channel.commonutils.logger.b.a(" updated geofence statue about geo_id:" + stringExtra + " falied. current_statue:Unknown");
            }
            com.xiaomi.smack.util.e.a(new by(this, context, stringExtra, stringExtra2));
            com.xiaomi.channel.commonutils.logger.b.c("ownresilt结果:state= " + stringExtra2 + "\n describe=" + stringExtra);
        }
    }
}
