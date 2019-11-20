package com.xiaomi.push.service;

import com.xiaomi.push.ff;
import com.xiaomi.push.fr;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
class bh implements fr {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fr
    public void a(ff ffVar) {
        this.a.a(new XMPushService.c(ffVar));
    }

    @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
    public void a(gd gdVar) {
        this.a.a(new XMPushService.k(gdVar));
    }
}
