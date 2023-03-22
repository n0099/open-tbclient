package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.id;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public final class ad extends XMPushService.j {
    public final /* synthetic */ id a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f881a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f882a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(int i, XMPushService xMPushService, id idVar, String str) {
        super(i);
        this.f881a = xMPushService;
        this.a = idVar;
        this.f882a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo674a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo391a() {
        try {
            id a = y.a((Context) this.f881a, this.a);
            a.m543a().a("absent_target_package", this.f882a);
            ah.a(this.f881a, a);
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f881a.a(10, e);
        }
    }
}
