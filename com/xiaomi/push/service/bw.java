package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bw implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.i f14587a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.f978a = xMPushService;
        this.f14587a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f978a.a(this.f14587a);
    }
}
