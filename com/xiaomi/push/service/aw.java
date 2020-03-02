package com.xiaomi.push.service;

import com.xiaomi.push.ff;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aw extends XMPushService.i {
    private ff a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f875a;

    public aw(XMPushService xMPushService, ff ffVar) {
        super(4);
        this.f875a = null;
        this.f875a = xMPushService;
        this.a = ffVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.a != null) {
                this.f875a.a(this.a);
            }
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f875a.a(10, e);
        }
    }
}
