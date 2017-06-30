package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bl extends XMPushService.h {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        if (this.b.i != null) {
            this.b.i.h();
            this.b.i = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "disconnect for disable push";
    }
}
