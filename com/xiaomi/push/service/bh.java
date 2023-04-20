package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes9.dex */
public class bh implements bg.b.a {
    public final /* synthetic */ bg.b a;

    public bh(bg.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        XMPushService.c cVar3;
        XMPushService.c cVar4;
        if (cVar2 == bg.c.binding) {
            XMPushService xMPushService = this.a.f931a;
            cVar4 = this.a.f930a;
            xMPushService.a(cVar4, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.a.f931a;
        cVar3 = this.a.f930a;
        xMPushService2.b(cVar3);
    }
}
