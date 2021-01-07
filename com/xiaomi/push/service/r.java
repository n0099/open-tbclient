package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class r extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f14615a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f1003a = xMPushService;
        this.f14615a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            w.a(this.f1003a, p.a((Context) this.f1003a, this.f14615a));
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1003a.a(10, e);
        }
    }
}
