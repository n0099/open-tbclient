package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bv extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(XMPushService xMPushService, int i) {
        super(i);
        this.f14287a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        w.a(this.f14287a);
        if (com.xiaomi.push.az.b(this.f14287a)) {
            this.f14287a.a(true);
        }
    }
}
