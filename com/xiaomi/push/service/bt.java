package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bt extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41900a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, int i2) {
        super(i2);
        this.f41900a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.f41900a.f840a != null) {
            this.f41900a.f840a.b(15, (Exception) null);
            this.f41900a.f840a = null;
        }
    }
}
