package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hj;
/* loaded from: classes8.dex */
public /* synthetic */ class an {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206662, "Lcom/xiaomi/mipush/sdk/an;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206662, "Lcom/xiaomi/mipush/sdk/an;");
                return;
            }
        }
        int[] iArr = new int[hj.values().length];
        a = iArr;
        try {
            iArr[hj.e.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hj.a.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hj.b.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hj.c.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hj.d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hj.j.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hj.i.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
