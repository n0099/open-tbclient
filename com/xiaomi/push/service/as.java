package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes8.dex */
class as extends XMPushService.i {
    final /* synthetic */ ap.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ap.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (ap.a().a(this.a.f871a.g, this.a.f871a.f867b).f858a == null) {
            ap.b.this.f860a.a(this.a.f871a.g, this.a.f871a.f867b, 2, null, null);
        }
    }
}
