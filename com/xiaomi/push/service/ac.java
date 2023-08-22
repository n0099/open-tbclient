package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ac extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f881a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(int i, XMPushService xMPushService, id idVar) {
        super(i);
        this.f881a = xMPushService;
        this.a = idVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            id a = y.a((Context) this.f881a, this.a);
            a.m624a().a("miui_message_unrecognized", "1");
            ah.a(this.f881a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f881a.a(10, e);
        }
    }
}
