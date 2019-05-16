package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
/* loaded from: classes3.dex */
class by implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ bx d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, Context context, String str, String str2) {
        this.d = bxVar;
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<com.xiaomi.push.service.module.a> it = i.a(this.a).c(this.b).iterator();
        while (it.hasNext()) {
            com.xiaomi.push.service.module.a next = it.next();
            if (XMPushService.a(next.e(), this.c)) {
                if (next.a() >= System.currentTimeMillis()) {
                    byte[] d = next.d();
                    if (d == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("Geo canBeShownMessage content null");
                    } else {
                        Intent a = x.a(d, System.currentTimeMillis());
                        if (a == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("Geo canBeShownMessage intent null");
                        } else {
                            x.a(this.d.a, (String) null, d, a, true);
                            if (i.a(this.d.a).a(next.b()) == 0) {
                                com.xiaomi.channel.commonutils.logger.b.a("show some exit geofence message. then remove this message failed. message_id:" + next.b());
                            }
                        }
                    }
                } else if (i.a(this.a).a(next.b()) == 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("XMPushService remove some geofence message failed. message_id:" + next.b());
                }
            }
        }
    }
}
