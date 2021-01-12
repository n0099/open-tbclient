package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14285a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m541f;
        super.onChange(z);
        m541f = this.f14285a.m541f();
        com.xiaomi.channel.commonutils.logger.b.m80a("ExtremePowerMode:" + m541f);
        if (m541f) {
            this.f14285a.a(new XMPushService.f(23, null));
        } else {
            this.f14285a.a(true);
        }
    }
}
