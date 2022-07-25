package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.service.XMJobService;
/* loaded from: classes8.dex */
public final class eu {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static a f326a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f327a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m321a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375408, "Lcom/xiaomi/push/eu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375408, "Lcom/xiaomi/push/eu;");
                return;
            }
        }
        f327a = XMJobService.class.getCanonicalName();
        a = 0;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (eu.class) {
                if (f326a == null) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m89a("[Alarm] stop alarm.");
                f326a.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (com.xiaomi.push.eu.f327a.equals(com.xiaomi.push.v.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        ev evVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
                evVar = new ev(applicationContext);
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
                                    if (!f327a.equals(serviceInfo.name)) {
                                        try {
                                        } catch (Exception unused) {
                                        }
                                    }
                                    i2 = 1;
                                    if (i2 == 1) {
                                        break;
                                    }
                                }
                                if (f327a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                    i = 1;
                                    break;
                                }
                                i++;
                            } catch (Exception e) {
                                e = e;
                                i = i2;
                                com.xiaomi.channel.commonutils.logger.b.m89a("check service err : " + e.getMessage());
                                if (i != 0) {
                                }
                                int i3 = Build.VERSION.SDK_INT;
                                evVar = new ev(applicationContext);
                                f326a = evVar;
                            }
                        }
                        i = i2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (i != 0 && v.m690a(applicationContext)) {
                    throw new RuntimeException("Should export service: " + f327a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
                }
                int i32 = Build.VERSION.SDK_INT;
                evVar = new ev(applicationContext);
            }
            f326a = evVar;
        }
    }

    public static synchronized void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) {
            synchronized (eu.class) {
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
                    f326a = new ex(context);
                }
            }
        }
    }

    public static synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            synchronized (eu.class) {
                if (f326a == null) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("timer is not initialized");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m89a("[Alarm] register alarm. (" + z + SmallTailInfo.EMOTION_SUFFIX);
                f326a.a(z);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m320a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (eu.class) {
                if (f326a == null) {
                    return false;
                }
                return f326a.m321a();
            }
        }
        return invokeV.booleanValue;
    }
}
