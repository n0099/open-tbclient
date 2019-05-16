package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
/* loaded from: classes3.dex */
class av extends XMPushService.i {
    final /* synthetic */ as.b.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(as.b.c cVar, int i) {
        super(i);
        this.b = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (as.a().b(this.b.a.h, this.b.a.b).o == null) {
            as.b.this.t.a(this.b.a.h, this.b.a.b, 2, null, null);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "check peer job";
    }
}
