package com.sdk.base.framework.a.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b extends Enum<b> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static int f60903b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f60904c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static int f60905d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static int f60906e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static int f60907f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static int f60908g = 7;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(922627827, "Lcom/sdk/base/framework/a/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(922627827, "Lcom/sdk/base/framework/a/c/b;");
        }
    }
}
