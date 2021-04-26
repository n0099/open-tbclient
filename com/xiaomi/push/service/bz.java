package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bz extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38950a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f38950a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m545g;
        super.onChange(z);
        m545g = this.f38950a.m545g();
        com.xiaomi.channel.commonutils.logger.b.m58a("SuperPowerMode:" + m545g);
        this.f38950a.e();
        if (!m545g) {
            this.f38950a.a(true);
            return;
        }
        XMPushService xMPushService = this.f38950a;
        xMPushService.a(new XMPushService.f(24, null));
    }
}
