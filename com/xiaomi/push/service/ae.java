package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ae extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f884a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f885a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, id idVar, String str, String str2) {
        super(i);
        this.f884a = xMPushService;
        this.a = idVar;
        this.f885a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            id a = y.a((Context) this.f884a, this.a);
            a.f633a.a("error", this.f885a);
            a.f633a.a("reason", this.b);
            ah.a(this.f884a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f884a.a(10, e);
        }
    }
}
