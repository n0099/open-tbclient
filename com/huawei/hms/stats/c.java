package com.huawei.hms.stats;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static boolean b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(869193815, "Lcom/huawei/hms/stats/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(869193815, "Lcom/huawei/hms/stats/c;");
                return;
            }
        }
        a = new Object();
    }

    public static boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a) {
                if (!b) {
                    boolean z2 = false;
                    try {
                        Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                        z = false;
                    }
                    try {
                        Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                        z2 = true;
                    } catch (ClassNotFoundException unused2) {
                        HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                    }
                    if (z && !z2) {
                        c = true;
                    }
                    b = true;
                    HMSLog.i("HianalyticsExist", "hianalytics exist: " + c);
                }
            }
            return c;
        }
        return invokeV.booleanValue;
    }
}
