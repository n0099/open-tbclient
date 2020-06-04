package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
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
        boolean m512f;
        super.onChange(z);
        m512f = this.a.m512f();
        com.xiaomi.channel.commonutils.logger.b.m51a("ExtremePowerMode:" + m512f);
        if (m512f) {
            this.a.a(new XMPushService.f(23, null));
        } else {
            this.a.a(true);
        }
    }
}
