package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes7.dex */
public final class yz0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<Integer> a;
    public static final Set<Integer> b;
    public static final Set<Integer> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755124638, "Lcom/repackage/yz0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755124638, "Lcom/repackage/yz0;");
                return;
            }
        }
        a = new HashSet();
        b = new HashSet();
        c = new HashSet();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        b.add(7);
        b.add(1);
        c.addAll(a);
        c.addAll(b);
    }

    public static String a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i < 0) {
                return "";
            }
            int i2 = i / 3600;
            int i3 = (i % 3600) / 60;
            int i4 = i % 60;
            return (i2 != 0 || z) ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return (String) invokeCommon.objValue;
    }

    public static long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs((j2 - j) / 86400000) : invokeCommon.longValue;
    }

    public static boolean c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeCommon.booleanValue;
    }
}
