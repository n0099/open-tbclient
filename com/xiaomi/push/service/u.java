package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
final class u extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f5117a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f929a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ii iiVar, String str) {
        super(i);
        this.f929a = xMPushService;
        this.f5117a = iiVar;
        this.f930a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f929a, this.f5117a);
            a2.m418a().a("absent_target_package", this.f930a);
            w.a(this.f929a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f929a.a(10, e);
        }
    }
}
