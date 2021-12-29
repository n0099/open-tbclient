package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.service.av;
/* loaded from: classes4.dex */
public /* synthetic */ class gu {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373486, "Lcom/xiaomi/push/gu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373486, "Lcom/xiaomi/push/gu;");
                return;
            }
        }
        int[] iArr = new int[av.c.values().length];
        a = iArr;
        try {
            iArr[av.c.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[av.c.f63827b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[av.c.f63828c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
