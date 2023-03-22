package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes8.dex */
public final class et {

    /* renamed from: a  reason: collision with other field name */
    public static a f329a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f330a = XMJobService.class.getCanonicalName();
    public static int a = 0;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean mo386a();
    }

    public static synchronized void a() {
        synchronized (et.class) {
            if (f329a == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] stop alarm.");
            f329a.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        if (com.xiaomi.push.et.f330a.equals(com.xiaomi.push.s.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        eu euVar;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            euVar = new eu(applicationContext);
        } else {
            int i = 0;
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    int length = serviceInfoArr.length;
                    int i2 = 0;
                    while (i < length) {
                        try {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                if (!f330a.equals(serviceInfo.name)) {
                                    try {
                                    } catch (Exception unused) {
                                    }
                                }
                                i2 = 1;
                                if (i2 == 1) {
                                    break;
                                }
                            }
                            if (f330a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                i = 1;
                                break;
                            }
                            i++;
                        } catch (Exception e) {
                            e = e;
                            i = i2;
                            com.xiaomi.channel.commonutils.logger.b.m99a("check service err : " + e.getMessage());
                            if (i != 0) {
                            }
                            int i3 = Build.VERSION.SDK_INT;
                            euVar = new eu(applicationContext);
                            f329a = euVar;
                        }
                    }
                    i = i2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (i != 0 && s.m644a(applicationContext)) {
                throw new RuntimeException("Should export service: " + f330a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
            int i32 = Build.VERSION.SDK_INT;
            euVar = new eu(applicationContext);
        }
        f329a = euVar;
    }

    public static synchronized void a(Context context, int i) {
        synchronized (et.class) {
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
                f329a = new ew(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (et.class) {
            if (f329a == null) {
                com.xiaomi.channel.commonutils.logger.b.m99a("timer is not initialized");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("[Alarm] register alarm. (" + z + SmallTailInfo.EMOTION_SUFFIX);
            f329a.a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m385a() {
        synchronized (et.class) {
            if (f329a == null) {
                return false;
            }
            return f329a.mo386a();
        }
    }
}
