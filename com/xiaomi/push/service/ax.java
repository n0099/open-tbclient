package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class ax extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f38081a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av.b.c cVar, int i2) {
        super(i2);
        this.f38081a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av.b.c cVar = this.f38081a;
        if (cVar.f38075a == cVar.f915a.f902a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f38081a.f915a.f38069g);
            this.f38081a.f915a.f902a = null;
        }
    }
}
