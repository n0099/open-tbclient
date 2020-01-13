package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bo extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m491f;
        super.onChange(z);
        m491f = this.a.m491f();
        com.xiaomi.channel.commonutils.logger.b.m42a("ExtremePowerMode:" + m491f);
        if (m491f) {
            this.a.a(new XMPushService.f(23, null));
        } else {
            this.a.a(true);
        }
    }
}
