package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class gb extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f14041a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f462a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f14042b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(fz fzVar, int i, int i2, Exception exc) {
        super(i);
        this.f14041a = fzVar;
        this.f14042b = i2;
        this.f462a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.f14042b + ", " + this.f462a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f14041a.f14037b.a(this.f14042b, this.f462a);
    }
}
