package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c extends XMPushService.i {
    private XMPushService b;
    private com.xiaomi.slim.b[] c;

    public c(XMPushService xMPushService, com.xiaomi.slim.b[] bVarArr) {
        super(4);
        this.b = null;
        this.b = xMPushService;
        this.c = bVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            if (this.c != null) {
                this.b.a(this.c);
            }
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "batch send message.";
    }
}
