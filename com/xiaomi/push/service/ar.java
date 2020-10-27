package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes12.dex */
class ar extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap.b.c f5062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ap.b.c cVar, int i) {
        super(i);
        this.f5062a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.f5062a.f5059a == this.f5062a.f864a.f851a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f5062a.f864a.g);
            this.f5062a.f864a.f851a = null;
        }
    }
}
