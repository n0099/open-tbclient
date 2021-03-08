package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f8535a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f874a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f875a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f875a = false;
        this.f8535a = ilVar;
        this.f874a = weakReference;
        this.f875a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f874a == null || this.f8535a == null || (xMPushService = this.f874a.get()) == null) {
            return;
        }
        this.f8535a.a(an.a());
        this.f8535a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f8535a.a());
        try {
            String c = this.f8535a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f8535a.b(), this.f8535a, hm.Notification)), this.f875a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
