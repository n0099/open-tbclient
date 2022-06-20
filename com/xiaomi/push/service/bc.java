package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
/* loaded from: classes8.dex */
public /* synthetic */ class bc {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163077, "Lcom/xiaomi/push/service/bc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163077, "Lcom/xiaomi/push/service/bc;");
                return;
            }
        }
        int[] iArr = new int[hq.values().length];
        b = iArr;
        try {
            iArr[hq.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[hq.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[hq.c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[hq.d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hp.values().length];
        a = iArr2;
        try {
            iArr2[hp.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hp.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
