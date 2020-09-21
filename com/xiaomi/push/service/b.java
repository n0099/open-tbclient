package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class b extends ai.a {
    private il a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f874a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f875a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f875a = false;
        this.a = ilVar;
        this.f874a = weakReference;
        this.f875a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f874a == null || this.a == null || (xMPushService = this.f874a.get()) == null) {
            return;
        }
        this.a.a(an.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.a());
        try {
            String c = this.a.c();
            xMPushService.a(c, iw.a(w.a(c, this.a.b(), this.a, hm.Notification)), this.f875a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
