package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class u extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f41449a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f974a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ib ibVar) {
        super(i);
        this.f974a = xMPushService;
        this.f41449a = ibVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ib a2 = q.a((Context) this.f974a, this.f41449a);
            a2.m435a().a("miui_message_unrecognized", "1");
            y.a(this.f974a, a2);
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f974a.a(10, e2);
        }
    }
}
