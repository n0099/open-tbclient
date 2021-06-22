package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class bz extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41906a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41906a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m543g;
        super.onChange(z);
        m543g = this.f41906a.m543g();
        com.xiaomi.channel.commonutils.logger.b.m56a("SuperPowerMode:" + m543g);
        this.f41906a.e();
        if (!m543g) {
            this.f41906a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41906a;
        xMPushService.a(new XMPushService.f(24, null));
    }
}
