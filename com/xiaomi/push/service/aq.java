package com.xiaomi.push.service;

import com.kwad.sdk.collector.AppStatusRules;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class aq implements ap.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b f14250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap.b bVar) {
        this.f14250a = bVar;
    }

    @Override // com.xiaomi.push.service.ap.b.a
    public void a(ap.c cVar, ap.c cVar2, int i) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == ap.c.binding) {
            XMPushService xMPushService = this.f14250a.f934a;
            bVar2 = this.f14250a.f933a;
            xMPushService.a(bVar2, AppStatusRules.DEFAULT_GRANULARITY);
            return;
        }
        XMPushService xMPushService2 = this.f14250a.f934a;
        bVar = this.f14250a.f933a;
        xMPushService2.b(bVar);
    }
}
