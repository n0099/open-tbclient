package com.xiaomi.push.service;

import com.xiaomi.push.fa;
import com.xiaomi.push.fq;
import com.xiaomi.push.gc;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class br implements fq {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41898a;

    public br(XMPushService xMPushService) {
        this.f41898a = xMPushService;
    }

    @Override // com.xiaomi.push.fq
    public void a(fa faVar) {
        XMPushService xMPushService = this.f41898a;
        xMPushService.a(new XMPushService.c(faVar));
    }

    @Override // com.xiaomi.push.fq, com.xiaomi.push.fy
    public void a(gc gcVar) {
        XMPushService xMPushService = this.f41898a;
        xMPushService.a(new XMPushService.k(gcVar));
    }
}
