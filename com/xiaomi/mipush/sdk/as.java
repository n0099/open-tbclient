package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public /* synthetic */ class as {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f77288a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206507, "Lcom/xiaomi/mipush/sdk/as;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206507, "Lcom/xiaomi/mipush/sdk/as;");
                return;
            }
        }
        int[] iArr = new int[at.values().length];
        f77288a = iArr;
        try {
            iArr[at.f77289a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77288a[at.f77290b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77288a[at.f77291c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f77288a[at.f77292d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f77288a[at.f77293e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f77288a[at.f77294f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
