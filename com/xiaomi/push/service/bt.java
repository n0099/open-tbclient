package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class bt extends XMPushService.j {
    public fk a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f952a;

    public bt(XMPushService xMPushService, fk fkVar) {
        super(4);
        this.f952a = null;
        this.f952a = xMPushService;
        this.a = fkVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        try {
            if (this.a != null) {
                this.f952a.a(this.a);
                if (this.a.f376a != null) {
                    this.a.f376a.d = System.currentTimeMillis();
                    ao.a(this.f952a, "coord_up", this.a.f376a);
                }
            }
        } catch (gg e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f952a.a(10, e);
        }
    }
}
