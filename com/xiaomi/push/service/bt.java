package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
class bt extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m515f;
        super.onChange(z);
        m515f = this.a.m515f();
        com.xiaomi.channel.commonutils.logger.b.m54a("ExtremePowerMode:" + m515f);
        if (m515f) {
            this.a.a(new XMPushService.f(23, null));
        } else {
            this.a.a(true);
        }
    }
}
