package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
class bl implements fx {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fx
    public void a(fl flVar) {
        this.a.a(new XMPushService.c(flVar));
    }

    @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
    public void a(gj gjVar) {
        this.a.a(new XMPushService.k(gjVar));
    }
}
