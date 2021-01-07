package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ba extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private fl f14564a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f956a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f956a = null;
        this.f956a = xMPushService;
        this.f14564a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f14564a != null) {
                this.f956a.a(this.f14564a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f956a.a(10, e);
        }
    }
}
