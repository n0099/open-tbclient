package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
class bt extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f4863a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m508f;
        super.onChange(z);
        m508f = this.f4863a.m508f();
        com.xiaomi.channel.commonutils.logger.b.m47a("ExtremePowerMode:" + m508f);
        if (m508f) {
            this.f4863a.a(new XMPushService.f(23, null));
        } else {
            this.f4863a.a(true);
        }
    }
}
