package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes8.dex */
public final class fc {

    /* renamed from: a  reason: collision with other field name */
    private static a f317a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f318a = XMJobService.class.getCanonicalName();
    private static int a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m269a();
    }

    public static synchronized void a() {
        synchronized (fc.class) {
            if (f317a != null) {
                com.xiaomi.channel.commonutils.logger.b.c("stop alarm.");
                f317a.a();
            }
        }
    }

    public static void a(Context context) {
        Exception e;
        boolean z = false;
        boolean z2 = true;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f317a = new fd(applicationContext);
            return;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i = 0;
                while (i < length) {
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        if (f318a.equals(serviceInfo.name)) {
                            z = true;
                        } else {
                            try {
                                if (f318a.equals(t.a(applicationContext, serviceInfo.name).getSuperclass().getCanonicalName())) {
                                    z = true;
                                }
                            } catch (Exception e2) {
                            }
                        }
                        if (z) {
                            z2 = z;
                            break;
                        }
                    }
                    boolean z3 = z;
                    try {
                        if (f318a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            break;
                        }
                        i++;
                        z = z3;
                    } catch (Exception e3) {
                        e = e3;
                        z2 = z3;
                        com.xiaomi.channel.commonutils.logger.b.m48a("check service err : " + e.getMessage());
                        if (z2) {
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                        }
                        f317a = new fd(applicationContext);
                    }
                }
            }
            z2 = z;
        } catch (Exception e4) {
            z2 = z;
            e = e4;
        }
        if (z2 && t.m581a(applicationContext)) {
            throw new RuntimeException("Should export service: " + f318a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (Build.VERSION.SDK_INT < 21) {
        }
        f317a = new fd(applicationContext);
    }

    public static synchronized void a(Context context, int i) {
        synchronized (fc.class) {
            int i2 = a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    a = 2;
                } else {
                    a = 0;
                }
            }
            if (i2 != a && a == 2) {
                a();
                f317a = new ff(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (fc.class) {
            if (f317a == null) {
                com.xiaomi.channel.commonutils.logger.b.m48a("timer is not initialized");
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("register alarm. (" + z + ")");
                f317a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m268a() {
        boolean m269a;
        synchronized (fc.class) {
            m269a = f317a == null ? false : f317a.m269a();
        }
        return m269a;
    }
}
