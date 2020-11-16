package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class bw implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.i f5096a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(XMPushService xMPushService, XMPushService.i iVar) {
        this.f902a = xMPushService;
        this.f5096a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f902a.a(this.f5096a);
    }
}
