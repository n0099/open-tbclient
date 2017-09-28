package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class al implements ak.b.a {
    final /* synthetic */ ak.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.ak.b.a
    public void a(ak.c cVar, ak.c cVar2, int i) {
        XMPushService xMPushService;
        XMPushService.b bVar;
        XMPushService xMPushService2;
        XMPushService.b bVar2;
        if (cVar2 == ak.c.binding) {
            xMPushService2 = this.a.p;
            bVar2 = this.a.q;
            xMPushService2.a(bVar2, 60000L);
            return;
        }
        xMPushService = this.a.p;
        bVar = this.a.q;
        xMPushService.b(bVar);
    }
}
