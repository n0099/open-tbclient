package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.service.av;
/* loaded from: classes10.dex */
public /* synthetic */ class gu {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f77563a;
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
        f77563a = iArr;
        try {
            iArr[av.c.f77964a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77563a[av.c.f77965b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77563a[av.c.f77966c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
