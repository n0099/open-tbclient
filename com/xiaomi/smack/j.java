package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class j extends XMPushService.h {
    final /* synthetic */ int b;
    final /* synthetic */ Exception c;
    final /* synthetic */ h d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i, int i2, Exception exc) {
        super(i);
        this.d = hVar;
        this.b = i2;
        this.c = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        this.d.r.a(this.b, this.c);
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "shutdown the connection. " + this.b + ", " + this.c;
    }
}
