package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class s extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f14321a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1008a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f1008a = xMPushService;
        this.f14321a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f1008a, this.f14321a);
            a2.m443a().a("message_obsleted", "1");
            w.a(this.f1008a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1008a.a(10, e);
        }
    }
}
