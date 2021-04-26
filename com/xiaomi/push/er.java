package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes7.dex */
public final class er {

    /* renamed from: a  reason: collision with other field name */
    public static a f330a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f331a = XMJobService.class.getCanonicalName();

    /* renamed from: a  reason: collision with root package name */
    public static int f38359a = 0;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m285a();
    }

    public static synchronized void a() {
        synchronized (er.class) {
            if (f330a == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("stop alarm.");
            f330a.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        if (com.xiaomi.push.er.f331a.equals(com.xiaomi.push.t.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        es esVar;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            esVar = new es(applicationContext);
        } else {
            int i2 = 0;
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    int length = serviceInfoArr.length;
                    int i3 = 0;
                    while (i2 < length) {
                        try {
                            ServiceInfo serviceInfo = serviceInfoArr[i2];
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                if (!f331a.equals(serviceInfo.name)) {
                                    try {
                                    } catch (Exception unused) {
                                    }
                                }
                                i3 = 1;
                                if (i3 == 1) {
                                    break;
                                }
                            }
                            if (f331a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                i2 = 1;
                                break;
                            }
                            i2++;
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i3;
                            com.xiaomi.channel.commonutils.logger.b.m58a("check service err : " + e.getMessage());
                            if (i2 != 0) {
                            }
                            int i4 = Build.VERSION.SDK_INT;
                            esVar = new es(applicationContext);
                            f330a = esVar;
                        }
                    }
                    i2 = i3;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (i2 != 0 && t.m628a(applicationContext)) {
                throw new RuntimeException("Should export service: " + f331a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
            int i42 = Build.VERSION.SDK_INT;
            esVar = new es(applicationContext);
        }
        f330a = esVar;
    }

    public static synchronized void a(Context context, int i2) {
        synchronized (er.class) {
            int i3 = f38359a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i2 == 2) {
                    f38359a = 2;
                } else {
                    f38359a = 0;
                }
            }
            if (i3 != f38359a && f38359a == 2) {
                a();
                f330a = new eu(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (er.class) {
            if (f330a == null) {
                com.xiaomi.channel.commonutils.logger.b.m58a("timer is not initialized");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("register alarm. (" + z + SmallTailInfo.EMOTION_SUFFIX);
            f330a.a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m284a() {
        synchronized (er.class) {
            if (f330a == null) {
                return false;
            }
            return f330a.m285a();
        }
    }
}
