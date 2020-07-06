package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes8.dex */
class ar extends XMPushService.i {
    final /* synthetic */ ap.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ap.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.a.a == this.a.f872a.f859a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.f872a.g);
            this.a.f872a.f859a = null;
        }
    }
}
