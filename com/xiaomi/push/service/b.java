package com.xiaomi.push.service;

import com.xiaomi.push.aj;
import com.xiaomi.push.hh;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class b extends aj.a {
    public ig a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f916a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f917a;

    public b(ig igVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f917a = false;
        this.a = igVar;
        this.f916a = weakReference;
        this.f917a = z;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo310a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f916a;
        if (weakReference == null || this.a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.a.a(bd.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.m649a());
        try {
            String c = this.a.c();
            xMPushService.a(c, ir.a(ah.a(c, this.a.b(), this.a, hh.Notification)), this.f917a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
