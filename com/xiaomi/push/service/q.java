package com.xiaomi.push.service;

import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
final class q extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f8576a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f922a = xMPushService;
        this.f8576a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f922a, w.a(this.f8576a.b(), this.f8576a.m423a()));
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f922a.a(10, e);
        }
    }
}
