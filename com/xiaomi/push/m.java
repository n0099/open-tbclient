package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ ComponentName a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f821a;

    public m(Context context, ComponentName componentName) {
        this.f821a = context;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.f821a.getPackageManager();
            if (packageManager.getComponentEnabledSetting(this.a) != 2) {
                packageManager.setComponentEnabledSetting(this.a, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m120a("close static register of network status receiver failed:" + th);
        }
    }
}
