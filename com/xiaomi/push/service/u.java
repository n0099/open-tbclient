package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class u extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f14620a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1010a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ii iiVar, String str) {
        super(i);
        this.f1010a = xMPushService;
        this.f14620a = iiVar;
        this.f1011a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f1010a, this.f14620a);
            a2.m437a().a("absent_target_package", this.f1011a);
            w.a(this.f1010a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1010a.a(10, e);
        }
    }
}
