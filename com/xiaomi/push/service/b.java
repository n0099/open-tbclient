package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b extends ai.a {
    private Cif a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f885a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f886a;

    public b(Cif cif, WeakReference<XMPushService> weakReference, boolean z) {
        this.f886a = false;
        this.a = cif;
        this.f885a = weakReference;
        this.f886a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f885a == null || this.a == null || (xMPushService = this.f885a.get()) == null) {
            return;
        }
        this.a.a(aj.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.a());
        try {
            String c = this.a.c();
            xMPushService.a(c, iq.a(w.a(c, this.a.b(), this.a, hg.Notification)), this.f886a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
