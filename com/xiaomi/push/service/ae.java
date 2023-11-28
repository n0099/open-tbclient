package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ae extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f879a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f880a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, id idVar, String str, String str2) {
        super(i);
        this.f879a = xMPushService;
        this.a = idVar;
        this.f880a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo765a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo482a() {
        try {
            id a = y.a((Context) this.f879a, this.a);
            a.f628a.a("error", this.f880a);
            a.f628a.a("reason", this.b);
            ah.a(this.f879a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f879a.a(10, e);
        }
    }
}
