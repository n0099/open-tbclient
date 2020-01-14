package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class r extends XMPushService.i {
    final /* synthetic */ ic a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f928a = xMPushService;
        this.a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f928a, p.a((Context) this.f928a, this.a));
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f928a.a(10, e);
        }
    }
}
