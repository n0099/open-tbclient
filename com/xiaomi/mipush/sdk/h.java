package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public /* synthetic */ class h {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78185991, "Lcom/xiaomi/mipush/sdk/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78185991, "Lcom/xiaomi/mipush/sdk/h;");
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
            a[e.f63279b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[e.f63280c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[e.f63281d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
