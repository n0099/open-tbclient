package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bp implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(XMPushService xMPushService) {
        this.f5089a = xMPushService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        com.xiaomi.channel.commonutils.logger.b.b("onServiceConnected " + iBinder);
        Service a2 = XMJobService.a();
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m55a("XMService connected but innerService is null " + iBinder);
            return;
        }
        XMPushService xMPushService = this.f5089a;
        i = XMPushService.d;
        xMPushService.startForeground(i, XMPushService.a((Context) this.f5089a));
        i2 = XMPushService.d;
        a2.startForeground(i2, XMPushService.a((Context) this.f5089a));
        a2.stopForeground(true);
        this.f5089a.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
