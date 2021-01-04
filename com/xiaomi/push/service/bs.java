package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes6.dex */
class bs implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(XMPushService xMPushService) {
        this.f14583a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.a
    public void a() {
        this.f14583a.e();
        if (ap.a().m562a() <= 0) {
            this.f14583a.a(new XMPushService.f(12, null));
        }
    }
}
