package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class c extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f5098a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f902a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.f5098a = null;
        this.f5098a = xMPushService;
        this.f902a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.f902a != null) {
                this.f5098a.a(this.f902a);
            }
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f5098a.a(10, e);
        }
    }
}
