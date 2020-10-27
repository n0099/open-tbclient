package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f5070a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f872a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f873a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f873a = false;
        this.f5070a = ilVar;
        this.f872a = weakReference;
        this.f873a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f872a == null || this.f5070a == null || (xMPushService = this.f872a.get()) == null) {
            return;
        }
        this.f5070a.a(an.a());
        this.f5070a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f5070a.a());
        try {
            String c = this.f5070a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f5070a.b(), this.f5070a, hm.Notification)), this.f873a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
