package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
class bu extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m516g;
        super.onChange(z);
        m516g = this.a.m516g();
        com.xiaomi.channel.commonutils.logger.b.m54a("SuperPowerMode:" + m516g);
        this.a.e();
        if (m516g) {
            this.a.a(new XMPushService.f(24, null));
        } else {
            this.a.a(true);
        }
    }
}
