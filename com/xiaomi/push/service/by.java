package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class by extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f38194a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f38194a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m543f;
        super.onChange(z);
        m543f = this.f38194a.m543f();
        com.xiaomi.channel.commonutils.logger.b.m57a("ExtremePowerMode:" + m543f);
        if (!m543f) {
            this.f38194a.a(true);
            return;
        }
        XMPushService xMPushService = this.f38194a;
        xMPushService.a(new XMPushService.f(23, null));
    }
}
