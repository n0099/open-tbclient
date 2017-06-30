package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak;
/* loaded from: classes2.dex */
class bf implements ak.a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ak.a
    public void a() {
        this.a.n();
        if (ak.a().c() <= 0) {
            this.a.a(new XMPushService.f(12, null));
        }
    }
}
