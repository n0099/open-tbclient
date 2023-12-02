package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class z extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f1008a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f1008a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo765a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo482a() {
        try {
            ah.a(this.f1008a, ah.a(this.a.b(), this.a.m635a()));
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1008a.a(10, e);
        }
    }
}
