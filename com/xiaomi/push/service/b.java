package com.xiaomi.push.service;

import com.xiaomi.push.aj;
import com.xiaomi.push.hh;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class b extends aj.a {
    public ig a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f920a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f921a;

    public b(ig igVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f921a = false;
        this.a = igVar;
        this.f920a = weakReference;
        this.f921a = z;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo219a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f920a;
        if (weakReference == null || this.a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.a.a(bd.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.m558a());
        try {
            String c = this.a.c();
            xMPushService.a(c, ir.a(ah.a(c, this.a.b(), this.a, hh.Notification)), this.f921a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
