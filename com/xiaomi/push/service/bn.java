package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* loaded from: classes5.dex */
class bn implements al.a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.al.a
    public void a() {
        this.a.e();
        if (al.a().m496a() <= 0) {
            this.a.a(new XMPushService.f(12, null));
        }
    }
}
