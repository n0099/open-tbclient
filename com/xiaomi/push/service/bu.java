package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14586a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m546g;
        super.onChange(z);
        m546g = this.f14586a.m546g();
        com.xiaomi.channel.commonutils.logger.b.m84a("SuperPowerMode:" + m546g);
        this.f14586a.e();
        if (m546g) {
            this.f14586a.a(new XMPushService.f(24, null));
        } else {
            this.f14586a.a(true);
        }
    }
}
