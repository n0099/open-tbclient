package com.xiaomi.push.service;

import com.xiaomi.push.fx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
final class q extends XMPushService.i {
    final /* synthetic */ ic a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f923a = xMPushService;
        this.a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f923a, w.a(this.a.b(), this.a.m385a()));
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f923a.a(10, e);
        }
    }
}
