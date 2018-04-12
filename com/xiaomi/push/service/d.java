package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.f;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d extends f.a {
    private XMPushService a;

    public d(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.channel.commonutils.misc.f.a
    public int a() {
        return 15;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<com.xiaomi.push.service.module.b> it = g.a(this.a).a().iterator();
        while (it.hasNext()) {
            com.xiaomi.push.service.module.b next = it.next();
            if (next.a() < System.currentTimeMillis()) {
                if (g.a(this.a).a(next.b()) == 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("GeofenceDbCleaner delete a geofence message failed message_id:" + next.b());
                }
                s.a(this.a, s.a(next.d()), false, false, true);
            }
        }
    }
}
