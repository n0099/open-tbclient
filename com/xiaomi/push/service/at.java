package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class at implements as.b.a {
    final /* synthetic */ as.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.as.b.a
    public void a(as.c cVar, as.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == as.c.binding) {
            XMPushService xMPushService = this.a.t;
            bVar2 = this.a.v;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.a.t;
        bVar = this.a.v;
        xMPushService2.b(bVar);
    }
}
