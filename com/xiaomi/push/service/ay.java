package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class ay extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f40979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(av.b.c cVar, int i) {
        super(i);
        this.f40979a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av a2 = av.a();
        av.b bVar = this.f40979a.f915a;
        if (a2.a(bVar.f40967g, bVar.f911b).f902a == null) {
            XMPushService xMPushService = av.b.this.f904a;
            av.b bVar2 = this.f40979a.f915a;
            xMPushService.a(bVar2.f40967g, bVar2.f911b, 2, null, null);
        }
    }
}
