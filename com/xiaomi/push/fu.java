package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
class fu extends XMPushService.i {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ft f393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu(ft ftVar, int i, long j) {
        super(i);
        this.f393a = ftVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f393a.c() || this.f393a.a(this.a)) {
            return;
        }
        this.f393a.b.a(22, (Exception) null);
    }
}
