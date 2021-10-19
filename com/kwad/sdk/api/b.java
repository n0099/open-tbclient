package com.kwad.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f71415a;

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f71416b;

    /* renamed from: c  reason: collision with root package name */
    public static final Boolean f71417c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(52258505, "Lcom/kwad/sdk/api/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(52258505, "Lcom/kwad/sdk/api/b;");
                return;
            }
        }
        Boolean bool = Boolean.TRUE;
        f71415a = bool;
        f71416b = bool;
        f71417c = Boolean.FALSE;
    }
}
