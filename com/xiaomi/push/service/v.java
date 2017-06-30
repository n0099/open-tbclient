package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v extends XMPushService.h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.ab c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        super(i);
        this.b = xMPushService;
        this.c = abVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        try {
            com.xiaomi.xmpush.thrift.ab a = s.a((Context) this.b, this.c);
            a.m().a("message_obsleted", "1");
            aa.a(this.b, a);
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "send ack message for obsleted message.";
    }
}
