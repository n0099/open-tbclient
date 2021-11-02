package com.kwad.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f63999a;

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f64000b;

    /* renamed from: c  reason: collision with root package name */
    public static final Boolean f64001c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1450433484, "Lcom/kwad/sdk/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1450433484, "Lcom/kwad/sdk/b;");
                return;
            }
        }
        f63999a = Boolean.TRUE;
        Boolean bool = Boolean.FALSE;
        f64000b = bool;
        f64001c = bool;
    }
}
