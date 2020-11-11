package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ba extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private fl f5073a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f876a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f876a = null;
        this.f876a = xMPushService;
        this.f5073a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f5073a != null) {
                this.f876a.a(this.f5073a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f876a.a(10, e);
        }
    }
}
