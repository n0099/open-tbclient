package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
class ga extends XMPushService.i {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ fz f382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(fz fzVar, int i, long j) {
        super(i);
        this.f382a = fzVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f382a.c() || this.f382a.a(this.a)) {
            return;
        }
        this.f382a.b.a(22, (Exception) null);
    }
}
