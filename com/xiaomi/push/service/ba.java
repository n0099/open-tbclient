package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ba extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private fl f4843a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f877a;

    public ba(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f877a = null;
        this.f877a = xMPushService;
        this.f4843a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f4843a != null) {
                this.f877a.a(this.f4843a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f877a.a(10, e);
        }
    }
}
