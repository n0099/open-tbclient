package com.xiaomi.push.service;

import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
final class q extends XMPushService.i {
    final /* synthetic */ ii a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f927a = xMPushService;
        this.a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f927a, w.a(this.a.b(), this.a.m414a()));
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f927a.a(10, e);
        }
    }
}
