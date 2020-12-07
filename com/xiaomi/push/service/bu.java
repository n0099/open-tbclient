package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f4864a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m509g;
        super.onChange(z);
        m509g = this.f4864a.m509g();
        com.xiaomi.channel.commonutils.logger.b.m47a("SuperPowerMode:" + m509g);
        this.f4864a.e();
        if (m509g) {
            this.f4864a.a(new XMPushService.f(24, null));
        } else {
            this.f4864a.a(true);
        }
    }
}
