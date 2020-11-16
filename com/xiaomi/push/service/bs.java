package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes18.dex */
class bs implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(XMPushService xMPushService) {
        this.f5092a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.a
    public void a() {
        this.f5092a.e();
        if (ap.a().m546a() <= 0) {
            this.f5092a.a(new XMPushService.f(12, null));
        }
    }
}
