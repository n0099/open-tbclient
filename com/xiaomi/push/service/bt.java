package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f14585a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m545f;
        super.onChange(z);
        m545f = this.f14585a.m545f();
        com.xiaomi.channel.commonutils.logger.b.m84a("ExtremePowerMode:" + m545f);
        if (m545f) {
            this.f14585a.a(new XMPushService.f(23, null));
        } else {
            this.f14585a.a(true);
        }
    }
}
