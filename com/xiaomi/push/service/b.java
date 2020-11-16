package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes18.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f5072a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f877a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f878a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f878a = false;
        this.f5072a = ilVar;
        this.f877a = weakReference;
        this.f878a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo169a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f877a == null || this.f5072a == null || (xMPushService = this.f877a.get()) == null) {
            return;
        }
        this.f5072a.a(an.a());
        this.f5072a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f5072a.a());
        try {
            String c = this.f5072a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f5072a.b(), this.f5072a, hm.Notification)), this.f878a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
