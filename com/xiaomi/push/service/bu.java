package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f8557a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m520g;
        super.onChange(z);
        m520g = this.f8557a.m520g();
        com.xiaomi.channel.commonutils.logger.b.m58a("SuperPowerMode:" + m520g);
        this.f8557a.e();
        if (m520g) {
            this.f8557a.a(new XMPushService.f(24, null));
        } else {
            this.f8557a.a(true);
        }
    }
}
