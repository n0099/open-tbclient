package com.xiaomi.push.service;

import com.tencent.connect.common.Constants;
import com.xiaomi.push.ai;
import com.xiaomi.push.hf;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public ie f41277a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f917a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f918a;

    public b(ie ieVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f918a = false;
        this.f41277a = ieVar;
        this.f917a = weakReference;
        this.f918a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        return Constants.VIA_REPORT_TYPE_DATALINE;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f917a;
        if (weakReference == null || this.f41277a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.f41277a.a(at.a());
        this.f41277a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f41277a.m450a());
        try {
            String c2 = this.f41277a.c();
            xMPushService.a(c2, ip.a(y.a(c2, this.f41277a.b(), this.f41277a, hf.Notification)), this.f918a);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e2.toString());
        }
    }
}
