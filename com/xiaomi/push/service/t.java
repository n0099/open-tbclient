package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class t extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f41448a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f973a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i, XMPushService xMPushService, ib ibVar) {
        super(i);
        this.f973a = xMPushService;
        this.f41448a = ibVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ib a2 = q.a((Context) this.f973a, this.f41448a);
            a2.m435a().a("message_obsleted", "1");
            y.a(this.f973a, a2);
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f973a.a(10, e2);
        }
    }
}
