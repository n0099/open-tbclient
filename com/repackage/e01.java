package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class e01 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755791541, "Lcom/repackage/e01;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755791541, "Lcom/repackage/e01;");
                return;
            }
        }
        TimeUnit.DAYS.toMillis(1L);
        TimeUnit.HOURS.toMillis(1L);
        a = TimeUnit.MINUTES.toMillis(1L);
        TimeUnit.SECONDS.toMillis(1L);
    }

    public static boolean a(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? j - j2 > ((long) i) * a : invokeCommon.booleanValue;
    }
}
