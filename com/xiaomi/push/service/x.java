package com.xiaomi.push.service;

import com.xiaomi.push.fw;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hw;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public final class x extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f41358a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ie f979a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f980a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i, ie ieVar, ib ibVar, XMPushService xMPushService) {
        super(i);
        this.f979a = ieVar;
        this.f41358a = ibVar;
        this.f980a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            hw hwVar = new hw();
            hwVar.c(hp.CancelPushMessageACK.f506a);
            hwVar.a(this.f979a.m450a());
            hwVar.a(this.f979a.a());
            hwVar.b(this.f979a.b());
            hwVar.e(this.f979a.c());
            hwVar.a(0L);
            hwVar.d("success clear push message.");
            y.a(this.f980a, y.b(this.f41358a.b(), this.f41358a.m436a(), hwVar, hf.Notification));
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e2);
            this.f980a.a(10, e2);
        }
    }
}
