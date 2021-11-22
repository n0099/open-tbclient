package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
/* loaded from: classes2.dex */
public /* synthetic */ class as {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f72337a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f72338b;
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
        f72338b = iArr;
        try {
            iArr[hm.f72031a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f72338b[hm.f72032b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f72338b[hm.f72033c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f72338b[hm.f72034d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hl.values().length];
        f72337a = iArr2;
        try {
            iArr2[hl.f72029a.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f72337a[hl.f72030b.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
