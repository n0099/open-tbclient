package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14288a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m542g;
        super.onChange(z);
        m542g = this.f14288a.m542g();
        com.xiaomi.channel.commonutils.logger.b.m80a("SuperPowerMode:" + m542g);
        this.f14288a.e();
        if (m542g) {
            this.f14288a.a(new XMPushService.f(24, null));
        } else {
            this.f14288a.a(true);
        }
    }
}
