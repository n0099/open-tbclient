package com.kwad.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f63895a;

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f63896b;

    /* renamed from: c  reason: collision with root package name */
    public static final Boolean f63897c;
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
        f63895a = bool;
        f63896b = bool;
        f63897c = Boolean.FALSE;
    }
}
