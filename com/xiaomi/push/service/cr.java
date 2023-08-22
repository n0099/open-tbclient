package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class cr extends ContentObserver {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m742g;
        super.onChange(z);
        m742g = this.a.m742g();
        com.xiaomi.channel.commonutils.logger.b.m180a("SuperPowerMode:" + m742g);
        this.a.e();
        if (!m742g) {
            this.a.a(true);
            return;
        }
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.g(24, null));
    }
}
