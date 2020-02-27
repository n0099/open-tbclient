package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class b extends ai.a {
    private Cif a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f883a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f884a;

    public b(Cif cif, WeakReference<XMPushService> weakReference, boolean z) {
        this.f884a = false;
        this.a = cif;
        this.f883a = weakReference;
        this.f884a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo157a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f883a == null || this.a == null || (xMPushService = this.f883a.get()) == null) {
            return;
        }
        this.a.a(aj.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.a());
        try {
            String c = this.a.c();
            xMPushService.a(c, iq.a(w.a(c, this.a.b(), this.a, hg.Notification)), this.f884a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
