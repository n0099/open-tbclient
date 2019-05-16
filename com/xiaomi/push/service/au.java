package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
/* loaded from: classes3.dex */
class au extends XMPushService.i {
    final /* synthetic */ as.b.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(as.b.c cVar, int i) {
        super(i);
        this.b = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.b.b == this.b.a.o) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.b.a.h);
            this.b.a.o = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "clear peer job";
    }
}
