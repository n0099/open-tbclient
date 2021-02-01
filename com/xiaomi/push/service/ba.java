package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ba extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private fl f14266a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f955a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f955a = null;
        this.f955a = xMPushService;
        this.f14266a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f14266a != null) {
                this.f955a.a(this.f14266a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f955a.a(10, e);
        }
    }
}
