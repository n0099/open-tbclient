package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class c extends XMPushService.i {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f907a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f907a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f907a != null) {
                this.a.a(this.f907a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
