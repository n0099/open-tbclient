package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bw implements l.a {
    final /* synthetic */ XMPushService.i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.f904a = xMPushService;
        this.a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f904a.a(this.a);
    }
}
