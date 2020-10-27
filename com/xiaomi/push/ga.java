package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
class ga extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f4915a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ fz f380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(fz fzVar, int i, long j) {
        super(i);
        this.f380a = fzVar;
        this.f4915a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f4915a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f380a.c() || this.f380a.a(this.f4915a)) {
            return;
        }
        this.f380a.b.a(22, (Exception) null);
    }
}
