package com.sdk.r;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (a) {
                return true;
            }
            Long b = com.sdk.k.a.b(context, "access_limit_time");
            long currentTimeMillis = System.currentTimeMillis();
            if (b == null) {
                com.sdk.k.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                return true;
            } else if (currentTimeMillis - b.longValue() > 600000) {
                com.sdk.k.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                com.sdk.k.a.a(context, "access_limit_count", (Long) 0L);
                return true;
            } else {
                Long b2 = com.sdk.k.a.b(context, "access_limit_count");
                if (b2 != null) {
                    return b2.longValue() <= 30;
                }
                com.sdk.k.a.a(context, "access_limit_count", (Long) 0L);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            Long b = com.sdk.k.a.b(context, "access_limit_count");
            com.sdk.k.a.a(context, "access_limit_count", Long.valueOf(b == null ? 0L : b.longValue() + 1));
        }
    }
}
