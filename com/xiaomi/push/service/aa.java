package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aa extends XMPushService.i {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        super(i);
        this.b = xMPushService;
        this.c = afVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            com.xiaomi.xmpush.thrift.af a = x.a((Context) this.b, this.c);
            a.m().a("message_obsleted", "1");
            af.a(this.b, a);
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send ack message for obsleted message.";
    }
}
