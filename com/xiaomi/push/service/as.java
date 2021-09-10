package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
/* loaded from: classes10.dex */
public /* synthetic */ class as {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f78125a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f78126b;
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
        f78126b = iArr;
        try {
            iArr[hm.f77807a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f78126b[hm.f77808b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f78126b[hm.f77809c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f78126b[hm.f77810d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hl.values().length];
        f78125a = iArr2;
        try {
            iArr2[hl.f77805a.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f78125a[hl.f77806b.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
