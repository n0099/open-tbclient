package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t extends XMPushService.h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.ab c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        super(i);
        this.b = xMPushService;
        this.c = abVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        try {
            aa.a(this.b, aa.a(this.c.j(), this.c.h()));
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "send app absent message.";
    }
}
