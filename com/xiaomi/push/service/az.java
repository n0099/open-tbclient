package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class az implements com.xiaomi.smack.f {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.smack.f
    public void a(com.xiaomi.slim.b bVar) {
        this.a.a(new XMPushService.c(bVar));
    }

    @Override // com.xiaomi.smack.f
    public void b(com.xiaomi.smack.packet.d dVar) {
        this.a.a(new XMPushService.k(dVar));
    }
}
