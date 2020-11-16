package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes18.dex */
public final class fc {

    /* renamed from: a  reason: collision with other field name */
    private static a f315a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f316a = XMJobService.class.getCanonicalName();

    /* renamed from: a  reason: collision with root package name */
    private static int f4897a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m278a();
    }

    public static synchronized void a() {
        synchronized (fc.class) {
            if (f315a != null) {
                com.xiaomi.channel.commonutils.logger.b.c("stop alarm.");
                f315a.a();
            }
        }
    }

    public static void a(Context context) {
        Exception e;
        boolean z = false;
        boolean z2 = true;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f315a = new fd(applicationContext);
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
                        if (f316a.equals(serviceInfo.name)) {
                            z = true;
                        } else {
                            try {
                                if (f316a.equals(t.a(applicationContext, serviceInfo.name).getSuperclass().getCanonicalName())) {
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
                        if (f316a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            break;
                        }
                        i++;
                        z = z3;
                    } catch (Exception e3) {
                        e = e3;
                        z2 = z3;
                        com.xiaomi.channel.commonutils.logger.b.m57a("check service err : " + e.getMessage());
                        if (z2) {
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                        }
                        f315a = new fd(applicationContext);
                    }
                }
            }
            z2 = z;
        } catch (Exception e4) {
            z2 = z;
            e = e4;
        }
        if (z2 && t.m590a(applicationContext)) {
            throw new RuntimeException("Should export service: " + f316a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (Build.VERSION.SDK_INT < 21) {
        }
        f315a = new fd(applicationContext);
    }

    public static synchronized void a(Context context, int i) {
        synchronized (fc.class) {
            int i2 = f4897a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    f4897a = 2;
                } else {
                    f4897a = 0;
                }
            }
            if (i2 != f4897a && f4897a == 2) {
                a();
                f315a = new ff(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (fc.class) {
            if (f315a == null) {
                com.xiaomi.channel.commonutils.logger.b.m57a("timer is not initialized");
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("register alarm. (" + z + ")");
                f315a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m277a() {
        boolean m278a;
        synchronized (fc.class) {
            m278a = f315a == null ? false : f315a.m278a();
        }
        return m278a;
    }
}
