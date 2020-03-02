package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes8.dex */
public final class ew {

    /* renamed from: a  reason: collision with other field name */
    private static a f325a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f326a = XMJobService.class.getCanonicalName();
    private static int a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m264a();
    }

    public static synchronized void a() {
        synchronized (ew.class) {
            if (f325a != null) {
                f325a.a();
            }
        }
    }

    public static void a(Context context) {
        Exception e;
        boolean z = false;
        boolean z2 = true;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f325a = new ex(applicationContext);
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
                        if (f326a.equals(serviceInfo.name)) {
                            z = true;
                        } else {
                            try {
                                if (f326a.equals(Class.forName(serviceInfo.name).getSuperclass().getCanonicalName())) {
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
                        if (f326a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            break;
                        }
                        i++;
                        z = z3;
                    } catch (Exception e3) {
                        e = e3;
                        z2 = z3;
                        com.xiaomi.channel.commonutils.logger.b.m47a("check service err : " + e.getMessage());
                        if (z2) {
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                        }
                        f325a = new ex(applicationContext);
                    }
                }
            }
            z2 = z;
        } catch (Exception e4) {
            z2 = z;
            e = e4;
        }
        if (z2 && t.m565a(applicationContext)) {
            throw new RuntimeException("Should export service: " + f326a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (Build.VERSION.SDK_INT < 21) {
        }
        f325a = new ex(applicationContext);
    }

    public static synchronized void a(Context context, int i) {
        synchronized (ew.class) {
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
                f325a = new ez(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (ew.class) {
            if (f325a == null) {
                com.xiaomi.channel.commonutils.logger.b.m47a("timer is not initialized");
            } else {
                f325a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m263a() {
        boolean m264a;
        synchronized (ew.class) {
            m264a = f325a == null ? false : f325a.m264a();
        }
        return m264a;
    }
}
