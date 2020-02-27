package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
class fu extends XMPushService.i {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ft f394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu(ft ftVar, int i, long j) {
        super(i);
        this.f394a = ftVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f394a.c() || this.f394a.a(this.a)) {
            return;
        }
        this.f394a.b.a(22, (Exception) null);
    }
}
