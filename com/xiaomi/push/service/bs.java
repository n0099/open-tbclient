package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes7.dex */
class bs implements ap.a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ap.a
    public void a() {
        this.a.e();
        if (ap.a().m543a() <= 0) {
            this.a.a(new XMPushService.f(12, null));
        }
    }
}
