package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes8.dex */
public final class er {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f43058a;

    /* renamed from: a  reason: collision with other field name */
    public static a f333a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f334a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m297a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375501, "Lcom/xiaomi/push/er;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375501, "Lcom/xiaomi/push/er;");
                return;
            }
        }
        f334a = XMJobService.class.getCanonicalName();
        f43058a = 0;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (er.class) {
                if (f333a == null) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("stop alarm.");
                f333a.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (com.xiaomi.push.er.f334a.equals(com.xiaomi.push.t.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        es esVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
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
                                    if (!f334a.equals(serviceInfo.name)) {
                                        try {
                                        } catch (Exception unused) {
                                        }
                                    }
                                    i3 = 1;
                                    if (i3 == 1) {
                                        break;
                                    }
                                }
                                if (f334a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                    i2 = 1;
                                    break;
                                }
                                i2++;
                            } catch (Exception e2) {
                                e = e2;
                                i2 = i3;
                                com.xiaomi.channel.commonutils.logger.b.m70a("check service err : " + e.getMessage());
                                if (i2 != 0) {
                                }
                                int i4 = Build.VERSION.SDK_INT;
                                esVar = new es(applicationContext);
                                f333a = esVar;
                            }
                        }
                        i2 = i3;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (i2 != 0 && t.m640a(applicationContext)) {
                    throw new RuntimeException("Should export service: " + f334a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
                }
                int i42 = Build.VERSION.SDK_INT;
                esVar = new es(applicationContext);
            }
            f333a = esVar;
        }
    }

    public static synchronized void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i2) == null) {
            synchronized (er.class) {
                int i3 = f43058a;
                if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                    if (i2 == 2) {
                        f43058a = 2;
                    } else {
                        f43058a = 0;
                    }
                }
                if (i3 != f43058a && f43058a == 2) {
                    a();
                    f333a = new eu(context);
                }
            }
        }
    }

    public static synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, null, z) == null) {
            synchronized (er.class) {
                if (f333a == null) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("timer is not initialized");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("register alarm. (" + z + SmallTailInfo.EMOTION_SUFFIX);
                f333a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m296a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (er.class) {
                if (f333a == null) {
                    return false;
                }
                return f333a.m297a();
            }
        }
        return invokeV.booleanValue;
    }
}
