package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hf;
/* loaded from: classes10.dex */
public /* synthetic */ class am {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f76898a;
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
        f76898a = iArr;
        try {
            iArr[hf.f77385e.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f76898a[hf.f77381a.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f76898a[hf.f77382b.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f76898a[hf.f77383c.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f76898a[hf.f77384d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f76898a[hf.f77390j.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f76898a[hf.f77389i.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
