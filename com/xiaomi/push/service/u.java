package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class u extends XMPushService.i {
    final /* synthetic */ ic a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f935a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i, XMPushService xMPushService, ic icVar, String str) {
        super(i);
        this.f935a = xMPushService;
        this.a = icVar;
        this.f936a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ic a = p.a((Context) this.f935a, this.a);
            a.m396a().a("absent_target_package", this.f936a);
            w.a(this.f935a, a);
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f935a.a(10, e);
        }
    }
}
