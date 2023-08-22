package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class gd extends XMPushService.j {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ gc f431a;
    public final /* synthetic */ long b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(gc gcVar, int i, long j, long j2) {
        super(i);
        this.f431a = gcVar;
        this.a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        Thread.yield();
        if (!this.f431a.m509c() || this.f431a.a(this.a)) {
            return;
        }
        com.xiaomi.push.service.o.a(this.f431a.b).m822b();
        this.f431a.b.a(22, (Exception) null);
    }
}
