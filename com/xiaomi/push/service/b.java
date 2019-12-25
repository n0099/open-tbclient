package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class b extends ai.a {
    private Cif a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f887a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f888a;

    public b(Cif cif, WeakReference<XMPushService> weakReference, boolean z) {
        this.f888a = false;
        this.a = cif;
        this.f887a = weakReference;
        this.f888a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo143a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f887a == null || this.a == null || (xMPushService = this.f887a.get()) == null) {
            return;
        }
        this.a.a(aj.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.a());
        try {
            String c = this.a.c();
            xMPushService.a(c, iq.a(w.a(c, this.a.b(), this.a, hg.Notification)), this.f888a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
