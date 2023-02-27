package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public final class z extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f1012a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f1012a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo672a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo389a() {
        try {
            ah.a(this.f1012a, ah.a(this.a.b(), this.a.m542a()));
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1012a.a(10, e);
        }
    }
}
