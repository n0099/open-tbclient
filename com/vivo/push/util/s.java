package com.vivo.push.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(com.vivo.push.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cVar)) == null) {
            w b = w.b();
            int b2 = cVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            int a = b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT");
            long b3 = currentTimeMillis - b.b("com.vivo.push_preferences.operate." + b2 + "START_TIME", 0L);
            if (b3 <= 86400000 && b3 >= 0) {
                if (a >= cVar.f()) {
                    return 1001;
                }
                b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", a + 1);
                return 0;
            }
            b.a("com.vivo.push_preferences.operate." + b2 + "START_TIME", System.currentTimeMillis());
            b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", 1);
            return 0;
        }
        return invokeL.intValue;
    }
}
