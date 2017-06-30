package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
class be extends XMPushService.h {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        aa.a(this.b);
        if (com.xiaomi.channel.commonutils.network.d.d(this.b)) {
            this.b.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "prepare the mi push account.";
    }
}
