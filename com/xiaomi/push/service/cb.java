package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.m;
/* loaded from: classes7.dex */
public class cb implements m.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService.i f38127a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f943a;

    public cb(XMPushService xMPushService, XMPushService.i iVar) {
        this.f943a = xMPushService;
        this.f38127a = iVar;
    }

    @Override // com.xiaomi.push.service.m.a
    public void a() {
        this.f943a.a(this.f38127a);
    }
}
