package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bk implements ServiceConnection {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        com.xiaomi.channel.commonutils.logger.b.b("onServiceConnected " + iBinder);
        Service a = XMJobService.a();
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m30a("XMService connected but innerService is null " + iBinder);
            return;
        }
        XMPushService xMPushService = this.a;
        i = XMPushService.b;
        xMPushService.startForeground(i, XMPushService.a((Context) this.a));
        i2 = XMPushService.b;
        a.startForeground(i2, XMPushService.a((Context) this.a));
        a.stopForeground(true);
        this.a.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
