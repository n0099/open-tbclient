package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class c extends XMPushService.j {
    public XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public fk[] f965a;

    public c(XMPushService xMPushService, fk[] fkVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f965a = fkVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo756a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo473a() {
        try {
            if (this.f965a != null) {
                this.a.a(this.f965a);
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
