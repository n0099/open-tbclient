package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class ax extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f41267a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av.b.c cVar, int i) {
        super(i);
        this.f41267a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av.b.c cVar = this.f41267a;
        if (cVar.f41261a == cVar.f915a.f902a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f41267a.f915a.f41256g);
            this.f41267a.f915a.f902a = null;
        }
    }
}
