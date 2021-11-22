package com.sdk.base.framework.f.i;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f69169a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1065952328, "Lcom/sdk/base/framework/f/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1065952328, "Lcom/sdk/base/framework/f/i/b;");
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Long c2 = com.sdk.base.framework.f.b.a.c(context, "access_limit_time");
            long currentTimeMillis = System.currentTimeMillis();
            if (c2 == null) {
                com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                return true;
            } else if (currentTimeMillis - c2.longValue() > 600000) {
                com.sdk.base.framework.f.b.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
                com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
                return true;
            } else {
                Long c3 = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
                if (c3 != null) {
                    return c3.longValue() <= 30;
                }
                com.sdk.base.framework.f.b.a.a(context, "access_limit_count", (Long) 0L);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Long c2 = com.sdk.base.framework.f.b.a.c(context, "access_limit_count");
            com.sdk.base.framework.f.b.a.a(context, "access_limit_count", Long.valueOf(c2 == null ? 0L : c2.longValue() + 1));
        }
    }
}
