package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
final class u extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f5119a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f931a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ii iiVar, String str) {
        super(i);
        this.f931a = xMPushService;
        this.f5119a = iiVar;
        this.f932a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f931a, this.f5119a);
            a2.m418a().a("absent_target_package", this.f932a);
            w.a(this.f931a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f931a.a(10, e);
        }
    }
}
