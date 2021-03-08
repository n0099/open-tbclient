package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f8556a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m519f;
        super.onChange(z);
        m519f = this.f8556a.m519f();
        com.xiaomi.channel.commonutils.logger.b.m58a("ExtremePowerMode:" + m519f);
        if (m519f) {
            this.f8556a.a(new XMPushService.f(23, null));
        } else {
            this.f8556a.a(true);
        }
    }
}
