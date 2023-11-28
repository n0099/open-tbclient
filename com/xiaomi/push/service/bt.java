package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class bt extends XMPushService.j {
    public fk a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f947a;

    public bt(XMPushService xMPushService, fk fkVar) {
        super(4);
        this.f947a = null;
        this.f947a = xMPushService;
        this.a = fkVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo765a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo482a() {
        try {
            if (this.a != null) {
                this.f947a.a(this.a);
                if (this.a.f371a != null) {
                    this.a.f371a.d = System.currentTimeMillis();
                    ao.a(this.f947a, "coord_up", this.a.f371a);
                }
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f947a.a(10, e);
        }
    }
}
