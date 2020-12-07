package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
class bl implements fx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4855a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(XMPushService xMPushService) {
        this.f4855a = xMPushService;
    }

    @Override // com.xiaomi.push.fx
    public void a(fl flVar) {
        this.f4855a.a(new XMPushService.c(flVar));
    }

    @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
    public void a(gj gjVar) {
        this.f4855a.a(new XMPushService.k(gjVar));
    }
}
