package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes6.dex */
public final class fc {

    /* renamed from: a  reason: collision with other field name */
    private static a f392a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f393a = XMJobService.class.getCanonicalName();

    /* renamed from: a  reason: collision with root package name */
    private static int f14306a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m305a();
    }

    public static synchronized void a() {
        synchronized (fc.class) {
            if (f392a != null) {
                com.xiaomi.channel.commonutils.logger.b.c("stop alarm.");
                f392a.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        Exception e;
        PackageInfo packageInfo;
        boolean z = false;
        boolean z2 = true;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f392a = new fd(applicationContext);
            return;
        }
        try {
            packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
        } catch (Exception e2) {
            e = e2;
        }
        if (packageInfo.services != null) {
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            int length = serviceInfoArr.length;
            int i = 0;
            boolean z3 = false;
            while (true) {
                if (i >= length) {
                    z2 = z3;
                    break;
                }
                try {
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        if (f393a.equals(serviceInfo.name)) {
                            z3 = true;
                        } else {
                            try {
                                if (f393a.equals(t.a(applicationContext, serviceInfo.name).getSuperclass().getCanonicalName())) {
                                    z3 = true;
                                }
                            } catch (Exception e3) {
                            }
                        }
                        if (z3) {
                            z2 = z3;
                            break;
                        }
                    }
                    z = z3;
                    if (f393a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        break;
                    }
                    i++;
                    z3 = z;
                } catch (Exception e4) {
                    e = e4;
                    z = z3;
                    com.xiaomi.channel.commonutils.logger.b.m84a("check service err : " + e.getMessage());
                    z2 = z;
                    if (z2) {
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                    }
                    f392a = new fd(applicationContext);
                }
            }
            if (z2 && t.m617a(applicationContext)) {
                throw new RuntimeException("Should export service: " + f393a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
            if (Build.VERSION.SDK_INT >= 21) {
            }
            f392a = new fd(applicationContext);
        }
        z2 = z;
        if (z2) {
        }
        if (Build.VERSION.SDK_INT >= 21) {
        }
        f392a = new fd(applicationContext);
    }

    public static synchronized void a(Context context, int i) {
        synchronized (fc.class) {
            int i2 = f14306a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    f14306a = 2;
                } else {
                    f14306a = 0;
                }
            }
            if (i2 != f14306a && f14306a == 2) {
                a();
                f392a = new ff(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (fc.class) {
            if (f392a == null) {
                com.xiaomi.channel.commonutils.logger.b.m84a("timer is not initialized");
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("register alarm. (" + z + ")");
                f392a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m304a() {
        boolean m305a;
        synchronized (fc.class) {
            m305a = f392a == null ? false : f392a.m305a();
        }
        return m305a;
    }
}
