package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes5.dex */
class bs implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(XMPushService xMPushService) {
        this.f8555a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.a
    public void a() {
        this.f8555a.e();
        if (ap.a().m547a() <= 0) {
            this.f8555a.a(new XMPushService.f(12, null));
        }
    }
}
