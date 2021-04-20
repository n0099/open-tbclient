package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bz extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41309a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41309a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m542g;
        super.onChange(z);
        m542g = this.f41309a.m542g();
        com.xiaomi.channel.commonutils.logger.b.m55a("SuperPowerMode:" + m542g);
        this.f41309a.e();
        if (!m542g) {
            this.f41309a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41309a;
        xMPushService.a(new XMPushService.f(24, null));
    }
}
