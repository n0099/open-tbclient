package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
/* loaded from: classes8.dex */
public /* synthetic */ class as {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162612, "Lcom/xiaomi/push/service/as;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162612, "Lcom/xiaomi/push/service/as;");
                return;
            }
        }
        int[] iArr = new int[hm.values().length];
        b = iArr;
        try {
            iArr[hm.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[hm.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[hm.c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[hm.d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hl.values().length];
        a = iArr2;
        try {
            iArr2[hl.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hl.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
