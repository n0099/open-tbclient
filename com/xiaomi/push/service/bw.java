package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class bw implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.i f8559a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.f899a = xMPushService;
        this.f8559a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f899a.a(this.f8559a);
    }
}
