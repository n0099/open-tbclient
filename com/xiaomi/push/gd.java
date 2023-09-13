package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class gd extends XMPushService.j {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ gc f430a;
    public final /* synthetic */ long b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(gc gcVar, int i, long j, long j2) {
        super(i);
        this.f430a = gcVar;
        this.a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo756a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo473a() {
        Thread.yield();
        if (!this.f430a.m510c() || this.f430a.a(this.a)) {
            return;
        }
        com.xiaomi.push.service.o.a(this.f430a.b).m823b();
        this.f430a.b.a(22, (Exception) null);
    }
}
