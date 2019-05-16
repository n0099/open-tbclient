package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bv extends XMPushService.i {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        af.a(this.b);
        if (com.xiaomi.channel.commonutils.network.d.c(this.b)) {
            this.b.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "prepare the mi push account.";
    }
}
