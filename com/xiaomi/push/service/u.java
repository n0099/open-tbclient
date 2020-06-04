package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
final class u extends XMPushService.i {
    final /* synthetic */ ii a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f930a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ii iiVar, String str) {
        super(i);
        this.f930a = xMPushService;
        this.a = iiVar;
        this.f931a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a = p.a((Context) this.f930a, this.a);
            a.m415a().a("absent_target_package", this.f931a);
            w.a(this.f930a, a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f930a.a(10, e);
        }
    }
}
