package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bw implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.i f5094a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.f897a = xMPushService;
        this.f5094a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f897a.a(this.f5094a);
    }
}
