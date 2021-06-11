package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class by extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41802a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41802a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m542f;
        super.onChange(z);
        m542f = this.f41802a.m542f();
        com.xiaomi.channel.commonutils.logger.b.m56a("ExtremePowerMode:" + m542f);
        if (!m542f) {
            this.f41802a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41802a;
        xMPushService.a(new XMPushService.f(23, null));
    }
}
