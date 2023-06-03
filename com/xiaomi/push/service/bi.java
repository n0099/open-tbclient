package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes10.dex */
public class bi extends XMPushService.j {
    public final /* synthetic */ bg.b.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo750a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo467a() {
        bg.b.c cVar = this.a;
        if (cVar.a == cVar.f942a.f929a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.f942a.g);
            this.a.f942a.f929a = null;
        }
    }
}
