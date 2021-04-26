package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class ax extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f38907a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av.b.c cVar, int i2) {
        super(i2);
        this.f38907a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av.b.c cVar = this.f38907a;
        if (cVar.f38901a == cVar.f915a.f902a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f38907a.f915a.f38895g);
            this.f38907a.f915a.f902a = null;
        }
    }
}
