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
    public String mo755a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        bg.b.c cVar = this.a;
        if (cVar.a == cVar.f943a.f930a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.f943a.g);
            this.a.f943a.f930a = null;
        }
    }
}
