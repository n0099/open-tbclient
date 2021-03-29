package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class ca extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41022a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(XMPushService xMPushService, int i) {
        super(i);
        this.f41022a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        y.a(this.f41022a);
        if (com.xiaomi.push.bg.b(this.f41022a)) {
            this.f41022a.a(true);
        }
    }
}
