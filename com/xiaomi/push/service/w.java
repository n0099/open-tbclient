package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class w extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f41953a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f977a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f978a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f41954b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(int i2, XMPushService xMPushService, ib ibVar, String str, String str2) {
        super(i2);
        this.f977a = xMPushService;
        this.f41953a = ibVar;
        this.f978a = str;
        this.f41954b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ib a2 = q.a((Context) this.f977a, this.f41953a);
            a2.f629a.a("error", this.f978a);
            a2.f629a.a("reason", this.f41954b);
            y.a(this.f977a, a2);
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f977a.a(10, e2);
        }
    }
}
