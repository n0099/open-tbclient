package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class ad extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f882a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f883a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(int i, XMPushService xMPushService, id idVar, String str) {
        super(i);
        this.f882a = xMPushService;
        this.a = idVar;
        this.f883a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            id a = y.a((Context) this.f882a, this.a);
            a.m624a().a("absent_target_package", this.f883a);
            ah.a(this.f882a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f882a.a(10, e);
        }
    }
}
