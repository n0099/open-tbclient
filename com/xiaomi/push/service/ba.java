package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ba extends XMPushService.i {
    private fl a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f876a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f876a = null;
        this.f876a = xMPushService;
        this.a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.a != null) {
                this.f876a.a(this.a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f876a.a(10, e);
        }
    }
}
