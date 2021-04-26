package com.xiaomi.push.service;

import com.xiaomi.push.fa;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bg extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public fa f38931a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f925a;

    public bg(XMPushService xMPushService, fa faVar) {
        super(4);
        this.f925a = null;
        this.f925a = xMPushService;
        this.f38931a = faVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f38931a != null) {
                this.f925a.a(this.f38931a);
            }
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f925a.a(10, e2);
        }
    }
}
