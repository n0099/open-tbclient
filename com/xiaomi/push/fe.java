package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.service.bg;
/* loaded from: classes8.dex */
public /* synthetic */ class fe {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374943, "Lcom/xiaomi/push/fe;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374943, "Lcom/xiaomi/push/fe;");
                return;
            }
        }
        int[] iArr = new int[bg.c.values().length];
        a = iArr;
        try {
            iArr[bg.c.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[bg.c.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[bg.c.c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
