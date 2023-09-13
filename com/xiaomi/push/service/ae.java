package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ae extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f883a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f884a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, id idVar, String str, String str2) {
        super(i);
        this.f883a = xMPushService;
        this.a = idVar;
        this.f884a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo756a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo473a() {
        try {
            id a = y.a((Context) this.f883a, this.a);
            a.f632a.a("error", this.f884a);
            a.f632a.a("reason", this.b);
            ah.a(this.f883a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f883a.a(10, e);
        }
    }
}
