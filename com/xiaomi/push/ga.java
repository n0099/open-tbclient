package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
class ga extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4687a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ fz f383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(fz fzVar, int i, long j) {
        super(i);
        this.f383a = fzVar;
        this.f4687a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f4687a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f383a.c() || this.f383a.a(this.f4687a)) {
            return;
        }
        this.f383a.b.a(22, (Exception) null);
    }
}
