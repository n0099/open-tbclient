package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14585a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m535g;
        super.onChange(z);
        m535g = this.f14585a.m535g();
        com.xiaomi.channel.commonutils.logger.b.m73a("SuperPowerMode:" + m535g);
        this.f14585a.e();
        if (m535g) {
            this.f14585a.a(new XMPushService.f(24, null));
        } else {
            this.f14585a.a(true);
        }
    }
}
