package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f62877b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f62878c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f62879d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386576, "Lcom/xiaomi/push/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386576, "Lcom/xiaomi/push/f;");
                return;
            }
        }
        a = a(1, 3);
        f62877b = a(1, 4);
        f62878c = a(2, 0);
        f62879d = a(3, 2);
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 & 7 : invokeI.intValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? (i2 << 3) | i3 : invokeII.intValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 >>> 3 : invokeI.intValue;
    }
}
