package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
class gb extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f4688a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f384a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(fz fzVar, int i, int i2, Exception exc) {
        super(i);
        this.f4688a = fzVar;
        this.b = i2;
        this.f384a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.b + ", " + this.f384a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f4688a.b.a(this.b, this.f384a);
    }
}
