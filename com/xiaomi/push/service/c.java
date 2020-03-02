package com.xiaomi.push.service;

import com.xiaomi.push.ff;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c extends XMPushService.i {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private ff[] f903a;

    public c(XMPushService xMPushService, ff[] ffVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f903a = ffVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f903a != null) {
                this.a.a(this.f903a);
            }
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
