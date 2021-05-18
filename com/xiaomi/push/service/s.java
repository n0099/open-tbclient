package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class s extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f38238a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f972a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i2, XMPushService xMPushService, ib ibVar) {
        super(i2);
        this.f972a = xMPushService;
        this.f38238a = ibVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            y.a(this.f972a, q.a((Context) this.f972a, this.f38238a));
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f972a.a(10, e2);
        }
    }
}
