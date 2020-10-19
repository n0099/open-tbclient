package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes12.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f5093a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m516f;
        super.onChange(z);
        m516f = this.f5093a.m516f();
        com.xiaomi.channel.commonutils.logger.b.m55a("ExtremePowerMode:" + m516f);
        if (m516f) {
            this.f5093a.a(new XMPushService.f(23, null));
        } else {
            this.f5093a.a(true);
        }
    }
}
