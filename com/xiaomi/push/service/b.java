package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f14562a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f953a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f954a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f954a = false;
        this.f14562a = ilVar;
        this.f953a = weakReference;
        this.f954a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f953a == null || this.f14562a == null || (xMPushService = this.f953a.get()) == null) {
            return;
        }
        this.f14562a.a(an.a());
        this.f14562a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f14562a.a());
        try {
            String c = this.f14562a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f14562a.b(), this.f14562a, hm.Notification)), this.f954a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
