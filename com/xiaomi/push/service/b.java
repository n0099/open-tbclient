package com.xiaomi.push.service;

import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.lang.ref.WeakReference;
/* loaded from: classes18.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private il f4842a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f875a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f876a;

    public b(il ilVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f876a = false;
        this.f4842a = ilVar;
        this.f875a = weakReference;
        this.f876a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo159a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        if (this.f875a == null || this.f4842a == null || (xMPushService = this.f875a.get()) == null) {
            return;
        }
        this.f4842a.a(an.a());
        this.f4842a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f4842a.a());
        try {
            String c = this.f4842a.c();
            xMPushService.a(c, iw.a(w.a(c, this.f4842a.b(), this.f4842a, hm.Notification)), this.f876a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
