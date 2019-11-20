package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class am implements al.b.a {
    final /* synthetic */ al.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.al.b.a
    public void a(al.c cVar, al.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == al.c.binding) {
            XMPushService xMPushService = this.a.f856a;
            bVar2 = this.a.f855a;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.a.f856a;
        bVar = this.a.f855a;
        xMPushService2.b(bVar);
    }
}
