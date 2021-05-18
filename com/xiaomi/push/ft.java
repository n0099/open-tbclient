package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class ft extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37682a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ fs f410a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft(fs fsVar, int i2, long j) {
        super(i2);
        this.f410a = fsVar;
        this.f37682a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f37682a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (!this.f410a.m314c() || this.f410a.a(this.f37682a)) {
            return;
        }
        this.f410a.f37676b.a(22, (Exception) null);
    }
}
