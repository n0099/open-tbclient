package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
final class s extends XMPushService.i {
    final /* synthetic */ ii a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f934a = xMPushService;
        this.a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a = p.a((Context) this.f934a, this.a);
            a.m412a().a("message_obsleted", "1");
            w.a(this.f934a, a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f934a.a(10, e);
        }
    }
}
