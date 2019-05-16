package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ca extends XMPushService.i {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.b.l != null) {
            this.b.l.h();
            this.b.l = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "disconnect for disable push";
    }
}
