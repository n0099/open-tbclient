package com.kwad.components.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean CK;
    public static final Boolean CL;
    public static final Boolean CM;
    public static final Boolean CN;
    public static final Boolean aw;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266830953, "Lcom/kwad/components/core/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-266830953, "Lcom/kwad/components/core/a;");
                return;
            }
        }
        CK = Boolean.TRUE;
        Boolean bool = Boolean.FALSE;
        CL = bool;
        aw = bool;
        CM = bool;
        CN = bool;
    }
}
