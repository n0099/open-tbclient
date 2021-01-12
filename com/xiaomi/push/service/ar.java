package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes6.dex */
class ar extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b.c f14251a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ap.b.c cVar, int i) {
        super(i);
        this.f14251a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.f14251a.f14246a == this.f14251a.f945a.f932a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f14251a.f945a.g);
            this.f14251a.f945a.f932a = null;
        }
    }
}
