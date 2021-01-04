package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14584a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m534f;
        super.onChange(z);
        m534f = this.f14584a.m534f();
        com.xiaomi.channel.commonutils.logger.b.m73a("ExtremePowerMode:" + m534f);
        if (m534f) {
            this.f14584a.a(new XMPushService.f(23, null));
        } else {
            this.f14584a.a(true);
        }
    }
}
