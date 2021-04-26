package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class by extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f38949a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m544f;
        super.onChange(z);
        m544f = this.f38949a.m544f();
        com.xiaomi.channel.commonutils.logger.b.m58a("ExtremePowerMode:" + m544f);
        if (!m544f) {
            this.f38949a.a(true);
            return;
        }
        XMPushService xMPushService = this.f38949a;
        xMPushService.a(new XMPushService.f(23, null));
    }
}
