package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.h;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class f extends h.a {
    private XMPushService a;

    public f(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 15;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<com.xiaomi.push.service.module.a> it = i.a(this.a).a().iterator();
        while (it.hasNext()) {
            com.xiaomi.push.service.module.a next = it.next();
            if (next.a() < System.currentTimeMillis()) {
                if (i.a(this.a).a(next.b()) == 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("GeofenceDbCleaner delete a geofence message failed message_id:" + next.b());
                }
                x.a(this.a, x.a(next.d()), false, false, true);
            }
        }
    }
}
