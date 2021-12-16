package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hf;
/* loaded from: classes4.dex */
public /* synthetic */ class bq {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163511, "Lcom/xiaomi/push/service/bq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163511, "Lcom/xiaomi/push/service/bq;");
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
            a[hf.f63549b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hf.f63550c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hf.f63551d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hf.f63552e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hf.f63553f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hf.f63554g.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[hf.f63555h.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[hf.f63556i.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[hf.f63557j.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
