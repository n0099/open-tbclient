package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ab extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f879a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f879a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo756a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo473a() {
        try {
            id a = y.a((Context) this.f879a, this.a);
            a.m625a().a("message_obsleted", "1");
            ah.a(this.f879a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f879a.a(10, e);
        }
    }
}
