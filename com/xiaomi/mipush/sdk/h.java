package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f70627a;
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
        f70627a = iArr;
        try {
            iArr[e.f70621a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f70627a[e.f70622b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f70627a[e.f70623c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f70627a[e.f70624d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
