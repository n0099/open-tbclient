package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class ay extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f41761a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(av.b.c cVar, int i2) {
        super(i2);
        this.f41761a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av a2 = av.a();
        av.b bVar = this.f41761a.f915a;
        if (a2.a(bVar.f41748g, bVar.f911b).f902a == null) {
            XMPushService xMPushService = av.b.this.f904a;
            av.b bVar2 = this.f41761a.f915a;
            xMPushService.a(bVar2.f41748g, bVar2.f911b, 2, null, null);
        }
    }
}
