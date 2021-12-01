package com.kwad.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f56963b;

    /* renamed from: c  reason: collision with root package name */
    public static final Boolean f56964c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(52258474, "Lcom/kwad/sdk/api/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(52258474, "Lcom/kwad/sdk/api/a;");
                return;
            }
        }
        Boolean bool = Boolean.TRUE;
        a = bool;
        f56963b = bool;
        f56964c = Boolean.FALSE;
    }
}
