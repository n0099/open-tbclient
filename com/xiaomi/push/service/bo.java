package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
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
        boolean m479f;
        super.onChange(z);
        m479f = this.a.m479f();
        com.xiaomi.channel.commonutils.logger.b.m30a("ExtremePowerMode:" + m479f);
        if (m479f) {
            this.a.a(new XMPushService.f(23, null));
        } else {
            this.a.a(true);
        }
    }
}
