package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aq implements ap.b.a {
    final /* synthetic */ ap.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == ap.c.binding) {
            XMPushService xMPushService = this.a.f860a;
            bVar2 = this.a.f859a;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.a.f860a;
        bVar = this.a.f859a;
        xMPushService2.b(bVar);
    }
}
