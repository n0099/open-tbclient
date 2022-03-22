package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hf;
/* loaded from: classes7.dex */
public /* synthetic */ class ai {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206817, "Lcom/xiaomi/mipush/sdk/ai;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206817, "Lcom/xiaomi/mipush/sdk/ai;");
                return;
            }
        }
        int[] iArr = new int[hf.values().length];
        a = iArr;
        try {
            iArr[hf.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hf.f44322b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hf.f44323c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hf.f44324d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hf.f44325e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hf.f44326f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hf.f44327g.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[hf.f44328h.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[hf.i.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[hf.j.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
