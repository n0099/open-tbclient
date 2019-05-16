package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.h;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends h.a {
    private com.xiaomi.xmpush.thrift.ai a;
    private WeakReference<XMPushService> b;
    private boolean c;

    public b(com.xiaomi.xmpush.thrift.ai aiVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.c = false;
        this.a = aiVar;
        this.b = weakReference;
        this.c = z;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.b == null || this.a == null || (xMPushService = this.b.get()) == null) {
            return;
        }
        this.a.a(aq.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.c());
        try {
            String l = this.a.l();
            xMPushService.a(l, com.xiaomi.xmpush.thrift.at.a(af.a(l, this.a.e(), this.a, com.xiaomi.xmpush.thrift.a.Notification)), this.c);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
