package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public class cn implements Runnable {
    public final /* synthetic */ XMPushService a;

    public cn(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] disable ping receiver may be failure. " + th);
        }
    }
}
