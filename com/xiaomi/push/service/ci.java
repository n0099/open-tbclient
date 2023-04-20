package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.ga;
import com.xiaomi.push.gm;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
public class ci implements ga {
    public final /* synthetic */ XMPushService a;

    public ci(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.ga
    public void a(fk fkVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.d(fkVar));
    }

    @Override // com.xiaomi.push.ga
    public void a(gm gmVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.m(gmVar));
    }
}
