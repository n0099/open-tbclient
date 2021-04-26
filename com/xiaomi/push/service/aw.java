package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class aw implements av.b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b f38906a;

    public aw(av.b bVar) {
        this.f38906a = bVar;
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == av.c.binding) {
            XMPushService xMPushService = this.f38906a.f904a;
            bVar2 = this.f38906a.f903a;
            xMPushService.a(bVar2, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.f38906a.f904a;
        bVar = this.f38906a.f903a;
        xMPushService2.b(bVar);
    }
}
