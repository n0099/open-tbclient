package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class v extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f38241a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f975a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f976a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i2, XMPushService xMPushService, ib ibVar, String str) {
        super(i2);
        this.f975a = xMPushService;
        this.f38241a = ibVar;
        this.f976a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ib a2 = q.a((Context) this.f975a, this.f38241a);
            a2.m437a().a("absent_target_package", this.f976a);
            y.a(this.f975a, a2);
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f975a.a(10, e2);
        }
    }
}
