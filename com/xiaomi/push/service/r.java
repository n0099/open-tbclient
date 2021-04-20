package com.xiaomi.push.service;

import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class r extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f41347a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f966a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, XMPushService xMPushService, ib ibVar) {
        super(i);
        this.f966a = xMPushService;
        this.f41347a = ibVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            y.a(this.f966a, y.a(this.f41347a.b(), this.f41347a.m436a()));
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f966a.a(10, e2);
        }
    }
}
