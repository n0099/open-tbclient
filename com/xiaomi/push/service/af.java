package com.xiaomi.push.service;

import com.xiaomi.push.gg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hy;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class af extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ig f886a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f887a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, ig igVar, id idVar, XMPushService xMPushService) {
        super(i);
        this.f886a = igVar;
        this.a = idVar;
        this.f887a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            hy hyVar = new hy();
            hyVar.c(hr.CancelPushMessageACK.f509a);
            hyVar.a(this.f886a.m639a());
            hyVar.a(this.f886a.a());
            hyVar.b(this.f886a.b());
            hyVar.e(this.f886a.c());
            hyVar.a(0L);
            hyVar.d("success clear push message.");
            ah.a(this.f887a, ah.b(this.a.b(), this.a.m625a(), hyVar, hh.Notification));
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
            this.f887a.a(10, e);
        }
    }
}
