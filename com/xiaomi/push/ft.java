package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class ft extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f40915a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ fs f410a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft(fs fsVar, int i, long j) {
        super(i);
        this.f410a = fsVar;
        this.f40915a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f40915a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f410a.m312c() || this.f410a.a(this.f40915a)) {
            return;
        }
        this.f410a.f40909b.a(22, (Exception) null);
    }
}
