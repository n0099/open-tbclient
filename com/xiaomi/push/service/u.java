package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
final class u extends XMPushService.i {
    final /* synthetic */ ii a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f933a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ii iiVar, String str) {
        super(i);
        this.f933a = xMPushService;
        this.a = iiVar;
        this.f934a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a = p.a((Context) this.f933a, this.a);
            a.m418a().a("absent_target_package", this.f934a);
            w.a(this.f933a, a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f933a.a(10, e);
        }
    }
}
