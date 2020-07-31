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
        boolean m510f;
        super.onChange(z);
        m510f = this.a.m510f();
        com.xiaomi.channel.commonutils.logger.b.m49a("ExtremePowerMode:" + m510f);
        if (m510f) {
            this.a.a(new XMPushService.f(23, null));
        } else {
            this.a.a(true);
        }
    }
}
