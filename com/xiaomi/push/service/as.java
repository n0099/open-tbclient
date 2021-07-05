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

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f43583a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f43584b;
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
        f43584b = iArr;
        try {
            iArr[hm.f43277a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f43584b[hm.f43278b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f43584b[hm.f43279c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f43584b[hm.f43280d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hl.values().length];
        f43583a = iArr2;
        try {
            iArr2[hl.f43275a.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f43583a[hl.f43276b.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
