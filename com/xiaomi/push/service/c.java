package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f14590a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f981a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.f14590a = null;
        this.f14590a = xMPushService;
        this.f981a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f981a != null) {
                this.f14590a.a(this.f981a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f14590a.a(10, e);
        }
    }
}
