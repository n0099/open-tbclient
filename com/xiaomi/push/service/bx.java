package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class bx implements av.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38193a;

    public bx(XMPushService xMPushService) {
        this.f38193a = xMPushService;
    }

    @Override // com.xiaomi.push.service.av.a
    public void a() {
        this.f38193a.e();
        if (av.a().m586a() <= 0) {
            XMPushService xMPushService = this.f38193a;
            xMPushService.a(new XMPushService.f(12, null));
        }
    }
}
