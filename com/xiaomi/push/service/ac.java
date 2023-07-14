package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ac extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f880a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f880a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo752a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo469a() {
        try {
            id a = y.a((Context) this.f880a, this.a);
            a.m621a().a("miui_message_unrecognized", "1");
            ah.a(this.f880a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f880a.a(10, e);
        }
    }
}
