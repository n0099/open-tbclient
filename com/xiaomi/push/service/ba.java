package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ba extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private fl f5071a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f874a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f874a = null;
        this.f874a = xMPushService;
        this.f5071a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f5071a != null) {
                this.f874a.a(this.f5071a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f874a.a(10, e);
        }
    }
}
