package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class fu extends XMPushService.i {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ft f397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu(ft ftVar, int i, long j) {
        super(i);
        this.f397a = ftVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f397a.c() || this.f397a.a(this.a)) {
            return;
        }
        this.f397a.b.a(22, (Exception) null);
    }
}
