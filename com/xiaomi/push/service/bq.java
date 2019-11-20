package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bq implements l.a {
    final /* synthetic */ XMPushService.i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(XMPushService xMPushService, XMPushService.i iVar) {
        this.f898a = xMPushService;
        this.a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f898a.a(this.a);
    }
}
