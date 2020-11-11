package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class aq implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b f5063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap.b bVar) {
        this.f5063a = bVar;
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == ap.c.binding) {
            XMPushService xMPushService = this.f5063a.f855a;
            bVar2 = this.f5063a.f854a;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.f5063a.f855a;
        bVar = this.f5063a.f854a;
        xMPushService2.b(bVar);
    }
}
