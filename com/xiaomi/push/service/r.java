package com.xiaomi.push.service;

import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class r extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f38988a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f966a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i2, XMPushService xMPushService, ib ibVar) {
        super(i2);
        this.f966a = xMPushService;
        this.f38988a = ibVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            y.a(this.f966a, y.a(this.f38988a.b(), this.f38988a.m439a()));
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f966a.a(10, e2);
        }
    }
}
