package com.xiaomi.push.service;

import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
final class q extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f4883a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f923a = xMPushService;
        this.f4883a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f923a, w.a(this.f4883a.b(), this.f4883a.m412a()));
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f923a.a(10, e);
        }
    }
}
