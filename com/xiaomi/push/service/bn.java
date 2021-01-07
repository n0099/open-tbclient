package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bn extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(XMPushService xMPushService, int i) {
        super(i);
        this.f14579a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.f14579a.f881a != null) {
            this.f14579a.f881a.b(15, (Exception) null);
            this.f14579a.f881a = null;
        }
    }
}
