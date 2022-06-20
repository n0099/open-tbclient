package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wb4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static String b = "0";
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755207160, "Lcom/repackage/wb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755207160, "Lcom/repackage/wb4;");
                return;
            }
        }
        z64 b2 = b74.b();
        if (b2 != null) {
            b = b2.i().getString("key_h2_heart_beat_version", "0");
        }
    }

    public static long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            z64 b2 = b74.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timespan", i) : i;
        }
        return invokeI.longValue;
    }

    public static long b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            z64 b2 = b74.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timeout", i) : i;
        }
        return invokeI.longValue;
    }
}
