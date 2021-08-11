package com.vivo.push.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(com.vivo.push.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cVar)) == null) {
            w b2 = w.b();
            int b3 = cVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            int b4 = b2.b("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT");
            long b5 = currentTimeMillis - b2.b("com.vivo.push_preferences.operate." + b3 + "START_TIME", 0L);
            if (b5 <= 86400000 && b5 >= 0) {
                if (b4 >= cVar.f()) {
                    return 1001;
                }
                b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", b4 + 1);
                return 0;
            }
            b2.a("com.vivo.push_preferences.operate." + b3 + "START_TIME", System.currentTimeMillis());
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", 1);
            return 0;
        }
        return invokeL.intValue;
    }
}
