package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class fv extends XMPushService.i {
    final /* synthetic */ ft a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f394a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv(ft ftVar, int i, int i2, Exception exc) {
        super(i);
        this.a = ftVar;
        this.b = i2;
        this.f394a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.b + ", " + this.f394a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.a.b.a(this.b, this.f394a);
    }
}
