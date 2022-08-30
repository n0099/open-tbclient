package com.kwad.b.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean CK;
    public static final Boolean CM;
    public static final Boolean QK;
    public static final Boolean QL;
    public static final Boolean aw;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1943809854, "Lcom/kwad/b/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1943809854, "Lcom/kwad/b/kwai/a;");
                return;
            }
        }
        Boolean bool = Boolean.TRUE;
        CK = bool;
        QK = bool;
        Boolean bool2 = Boolean.FALSE;
        aw = bool2;
        CM = bool2;
        QL = Boolean.TRUE;
    }
}
