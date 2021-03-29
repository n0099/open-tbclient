package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class by extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41019a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41019a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m537f;
        super.onChange(z);
        m537f = this.f41019a.m537f();
        com.xiaomi.channel.commonutils.logger.b.m51a("ExtremePowerMode:" + m537f);
        if (!m537f) {
            this.f41019a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41019a;
        xMPushService.a(new XMPushService.f(23, null));
    }
}
