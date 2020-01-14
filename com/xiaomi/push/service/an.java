package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* loaded from: classes6.dex */
class an extends XMPushService.i {
    final /* synthetic */ al.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.a.a == this.a.f871a.f858a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.f871a.g);
            this.a.f871a.f858a = null;
        }
    }
}
