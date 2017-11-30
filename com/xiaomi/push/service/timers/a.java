package com.xiaomi.push.service.timers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.android.j;
/* loaded from: classes2.dex */
public final class a {
    private static InterfaceC0165a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.timers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0165a {
        void a();

        void a(boolean z);

        boolean b();
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (a != null) {
                a.a();
            }
        }
    }

    public static void a(Context context) {
        boolean z = false;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            a = new b(applicationContext);
            return;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    if ("com.xiaomi.push.service.XMJobService".equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("check service err : " + e.getMessage());
        }
        if (!z && j.b(applicationContext)) {
            throw new RuntimeException("Should export service: com.xiaomi.push.service.XMJobService with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (Build.VERSION.SDK_INT < 21 || !z) {
            a = new b(applicationContext);
            return;
        }
        try {
            if (Class.forName("android.app.job.JobService").getDeclaredField("mBinder") != null) {
                a = new c(applicationContext);
            }
        } catch (Exception e2) {
            a = new b(applicationContext);
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (a.class) {
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.a("timer is not initialized");
            } else {
                a.a(z);
            }
        }
    }

    public static synchronized boolean b() {
        boolean b;
        synchronized (a.class) {
            b = a == null ? false : a.b();
        }
        return b;
    }
}
