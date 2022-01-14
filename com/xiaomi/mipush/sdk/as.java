package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public /* synthetic */ class as {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
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
        a = iArr;
        try {
            iArr[at.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[at.f60886b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[at.f60887c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[at.f60888d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[at.f60889e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[at.f60890f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
