package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class bi extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.a.f813a != null) {
            this.a.f813a.b(15, (Exception) null);
            this.a.f813a = null;
        }
    }
}
