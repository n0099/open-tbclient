package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
class bn extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(XMPushService xMPushService, int i) {
        super(i);
        this.f8550a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.f8550a.f801a != null) {
            this.f8550a.f801a.b(15, (Exception) null);
            this.f8550a.f801a = null;
        }
    }
}
