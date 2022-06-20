package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hj;
/* loaded from: classes8.dex */
public /* synthetic */ class cf {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071164131, "Lcom/xiaomi/push/service/cf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071164131, "Lcom/xiaomi/push/service/cf;");
                return;
            }
        }
        int[] iArr = new int[hj.values().length];
        a = iArr;
        try {
            iArr[hj.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hj.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hj.c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hj.d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hj.e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hj.f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hj.g.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[hj.h.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[hj.i.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[hj.j.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
