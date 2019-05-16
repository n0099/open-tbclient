package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ae extends XMPushService.i {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.af c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, boolean z, boolean z2, boolean z3, boolean z4) {
        super(i);
        this.b = xMPushService;
        this.c = afVar;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            com.xiaomi.xmpush.thrift.af a = x.a((Context) this.b, this.c, this.d, this.e, this.f);
            if (this.g) {
                a.m().a("permission_to_location", ba.b);
            }
            af.a(this.b, a);
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send wrong message ack for message.";
    }
}
