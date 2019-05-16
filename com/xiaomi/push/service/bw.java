package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bw implements t.a {
    final /* synthetic */ XMPushService.i a;
    final /* synthetic */ XMPushService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.b = xMPushService;
        this.a = iVar;
    }

    @Override // com.xiaomi.push.service.t.a
    public void a() {
        this.b.a(this.a);
    }
}
