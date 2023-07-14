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
    public final /* synthetic */ ig f885a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f886a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, ig igVar, id idVar, XMPushService xMPushService) {
        super(i);
        this.f885a = igVar;
        this.a = idVar;
        this.f886a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo752a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo469a() {
        try {
            hy hyVar = new hy();
            hyVar.c(hr.CancelPushMessageACK.f508a);
            hyVar.a(this.f885a.m636a());
            hyVar.a(this.f885a.a());
            hyVar.b(this.f885a.b());
            hyVar.e(this.f885a.c());
            hyVar.a(0L);
            hyVar.d("success clear push message.");
            ah.a(this.f886a, ah.b(this.a.b(), this.a.m622a(), hyVar, hh.Notification));
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
            this.f886a.a(10, e);
        }
    }
}
