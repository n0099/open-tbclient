package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f14563a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f954a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f955a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f955a = false;
        this.f14563a = ilVar;
        this.f954a = weakReference;
        this.f955a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo196a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f954a == null || this.f14563a == null || (xMPushService = this.f954a.get()) == null) {
            return;
        }
        this.f14563a.a(an.a());
        this.f14563a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f14563a.a());
        try {
            String c = this.f14563a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f14563a.b(), this.f14563a, hm.Notification)), this.f955a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
