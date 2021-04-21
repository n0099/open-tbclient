package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class by extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41403a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m541f;
        super.onChange(z);
        m541f = this.f41403a.m541f();
        com.xiaomi.channel.commonutils.logger.b.m55a("ExtremePowerMode:" + m541f);
        if (!m541f) {
            this.f41403a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41403a;
        xMPushService.a(new XMPushService.f(23, null));
    }
}
