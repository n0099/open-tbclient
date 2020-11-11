package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
final class t extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f5118a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i, XMPushService xMPushService, ii iiVar) {
        super(i);
        this.f930a = xMPushService;
        this.f5118a = iiVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f930a, this.f5118a);
            a2.m418a().a("miui_message_unrecognized", "1");
            w.a(this.f930a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f930a.a(10, e);
        }
    }
}
