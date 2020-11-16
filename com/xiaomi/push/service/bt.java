package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
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
        boolean m518f;
        super.onChange(z);
        m518f = this.f5093a.m518f();
        com.xiaomi.channel.commonutils.logger.b.m57a("ExtremePowerMode:" + m518f);
        if (m518f) {
            this.f5093a.a(new XMPushService.f(23, null));
        } else {
            this.f5093a.a(true);
        }
    }
}
