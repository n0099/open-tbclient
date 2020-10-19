package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
class bu extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f5094a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m517g;
        super.onChange(z);
        m517g = this.f5094a.m517g();
        com.xiaomi.channel.commonutils.logger.b.m55a("SuperPowerMode:" + m517g);
        this.f5094a.e();
        if (m517g) {
            this.f5094a.a(new XMPushService.f(24, null));
        } else {
            this.f5094a.a(true);
        }
    }
}
