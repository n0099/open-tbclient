package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
class ba extends XMPushService.h {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public void a() {
        if (this.b.i != null) {
            this.b.i.b(15, (Exception) null);
            this.b.i = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.h
    public String b() {
        return "disconnect for service destroy.";
    }
}
