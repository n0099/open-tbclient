package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hf;
/* loaded from: classes6.dex */
public /* synthetic */ class am {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f40047a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;");
                return;
            }
        }
        int[] iArr = new int[hf.values().length];
        f40047a = iArr;
        try {
            iArr[hf.f40526e.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f40047a[hf.f40522a.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f40047a[hf.f40523b.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f40047a[hf.f40524c.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f40047a[hf.f40525d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f40047a[hf.j.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f40047a[hf.f40530i.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
