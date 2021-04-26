package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class ft extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f38437a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ fs f410a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft(fs fsVar, int i2, long j) {
        super(i2);
        this.f410a = fsVar;
        this.f38437a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f38437a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f410a.m315c() || this.f410a.a(this.f38437a)) {
            return;
        }
        this.f410a.f38431b.a(22, (Exception) null);
    }
}
