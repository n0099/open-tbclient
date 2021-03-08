package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
class gb extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f8381a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f383a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(fz fzVar, int i, int i2, Exception exc) {
        super(i);
        this.f8381a = fzVar;
        this.b = i2;
        this.f383a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.b + ", " + this.f383a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f8381a.b.a(this.b, this.f383a);
    }
}
