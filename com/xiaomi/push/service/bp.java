package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class bp extends XMPushService.i {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.b.l != null) {
            this.b.l.b(15, (Exception) null);
            this.b.l = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "disconnect for service destroy.";
    }
}
