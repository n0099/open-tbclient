package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bz extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38124a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f38124a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m544g;
        super.onChange(z);
        m544g = this.f38124a.m544g();
        com.xiaomi.channel.commonutils.logger.b.m57a("SuperPowerMode:" + m544g);
        this.f38124a.e();
        if (!m544g) {
            this.f38124a.a(true);
            return;
        }
        XMPushService xMPushService = this.f38124a;
        xMPushService.a(new XMPushService.f(24, null));
    }
}
