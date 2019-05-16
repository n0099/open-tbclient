package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ac extends XMPushService.i {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.af c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, String str) {
        super(i);
        this.b = xMPushService;
        this.c = afVar;
        this.d = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            com.xiaomi.xmpush.thrift.af a = x.a((Context) this.b, this.c);
            a.m().a("absent_target_package", this.d);
            af.a(this.b, a);
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send app absent ack message for message.";
    }
}
