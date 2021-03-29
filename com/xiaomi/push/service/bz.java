package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bz extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41020a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41020a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m538g;
        super.onChange(z);
        m538g = this.f41020a.m538g();
        com.xiaomi.channel.commonutils.logger.b.m51a("SuperPowerMode:" + m538g);
        this.f41020a.e();
        if (!m538g) {
            this.f41020a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41020a;
        xMPushService.a(new XMPushService.f(24, null));
    }
}
