package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class aq implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b f5061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap.b bVar) {
        this.f5061a = bVar;
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == ap.c.binding) {
            XMPushService xMPushService = this.f5061a.f853a;
            bVar2 = this.f5061a.f852a;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.f5061a.f853a;
        bVar = this.f5061a.f852a;
        xMPushService2.b(bVar);
    }
}
