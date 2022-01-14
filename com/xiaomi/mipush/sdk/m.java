package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public /* synthetic */ class m {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78186146, "Lcom/xiaomi/mipush/sdk/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78186146, "Lcom/xiaomi/mipush/sdk/m;");
                return;
            }
        }
        int[] iArr = new int[e.values().length];
        a = iArr;
        try {
            iArr[e.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[e.f60898b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[e.f60899c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[e.f60900d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
