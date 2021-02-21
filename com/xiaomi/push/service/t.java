package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class t extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f14322a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f1009a = xMPushService;
        this.f14322a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f1009a, this.f14322a);
            a2.m443a().a("miui_message_unrecognized", "1");
            w.a(this.f1009a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1009a.a(10, e);
        }
    }
}
