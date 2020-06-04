package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bp implements ServiceConnection {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        com.xiaomi.channel.commonutils.logger.b.b("onServiceConnected " + iBinder);
        Service a = XMJobService.a();
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m51a("XMService connected but innerService is null " + iBinder);
            return;
        }
        XMPushService xMPushService = this.a;
        i = XMPushService.d;
        xMPushService.startForeground(i, XMPushService.a((Context) this.a));
        i2 = XMPushService.d;
        a.startForeground(i2, XMPushService.a((Context) this.a));
        a.stopForeground(true);
        this.a.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
