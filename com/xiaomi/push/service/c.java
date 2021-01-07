package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f14591a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f982a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.f14591a = null;
        this.f14591a = xMPushService;
        this.f982a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f982a != null) {
                this.f14591a.a(this.f982a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f14591a.a(10, e);
        }
    }
}
