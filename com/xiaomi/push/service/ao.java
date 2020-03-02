package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* loaded from: classes8.dex */
class ao extends XMPushService.i {
    final /* synthetic */ al.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(al.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (al.a().a(this.a.f867a.g, this.a.f867a.f863b).f854a == null) {
            al.b.this.f856a.a(this.a.f867a.g, this.a.f867a.f863b, 2, null, null);
        }
    }
}
