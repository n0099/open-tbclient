package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes18.dex */
class bs implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4862a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(XMPushService xMPushService) {
        this.f4862a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.a
    public void a() {
        this.f4862a.e();
        if (ap.a().m536a() <= 0) {
            this.f4862a.a(new XMPushService.f(12, null));
        }
    }
}
