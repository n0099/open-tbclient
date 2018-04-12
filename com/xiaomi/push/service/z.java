package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class z extends XMPushService.h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.ab c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar, boolean z, boolean z2, boolean z3) {
        super(i);
        this.b = xMPushService;
        this.c = abVar;
        this.d = z;
        this.e = z2;
        this.f = z3;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        try {
            aa.a(this.b, s.a((Context) this.b, this.c, this.d, this.e, this.f));
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "send wrong message ack for message.";
    }
}
