package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
class gb extends XMPushService.i {
    final /* synthetic */ fz a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f382a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(fz fzVar, int i, int i2, Exception exc) {
        super(i);
        this.a = fzVar;
        this.b = i2;
        this.f382a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.b + ", " + this.f382a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.a.b.a(this.b, this.f382a);
    }
}
