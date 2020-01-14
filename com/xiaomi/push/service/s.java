package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class s extends XMPushService.i {
    final /* synthetic */ ic a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f934a = xMPushService;
        this.a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ic a = p.a((Context) this.f934a, this.a);
            a.m396a().a("message_obsleted", "1");
            w.a(this.f934a, a);
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f934a.a(10, e);
        }
    }
}
