package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
/* loaded from: classes3.dex */
class bu implements as.a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.as.a
    public void a() {
        this.a.o();
        if (as.a().c() <= 0) {
            this.a.a(new XMPushService.f(12, null));
        }
    }
}
