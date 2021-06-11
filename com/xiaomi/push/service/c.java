package com.xiaomi.push.service;

import com.xiaomi.push.fa;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class c extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f41804a;

    /* renamed from: a  reason: collision with other field name */
    public fa[] f942a;

    public c(XMPushService xMPushService, fa[] faVarArr) {
        super(4);
        this.f41804a = null;
        this.f41804a = xMPushService;
        this.f942a = faVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f942a != null) {
                this.f41804a.a(this.f942a);
            }
        } catch (fw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f41804a.a(10, e2);
        }
    }
}
