package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class bt extends XMPushService.j {
    public fk a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f951a;

    public bt(XMPushService xMPushService, fk fkVar) {
        super(4);
        this.f951a = null;
        this.f951a = xMPushService;
        this.a = fkVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo672a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo389a() {
        try {
            if (this.a != null) {
                this.f951a.a(this.a);
                if (this.a.f375a != null) {
                    this.a.f375a.d = System.currentTimeMillis();
                    ao.a(this.f951a, "coord_up", this.a.f375a);
                }
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f951a.a(10, e);
        }
    }
}
