package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public /* synthetic */ class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f77138a;
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
        f77138a = iArr;
        try {
            iArr[e.f77125a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77138a[e.f77126b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77138a[e.f77127c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f77138a[e.f77128d.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
