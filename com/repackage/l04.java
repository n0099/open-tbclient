package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k04 a() {
        InterceptResult invokeV;
        k04 k04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l04.class) {
                if (a == null) {
                    a = new k04();
                }
                k04Var = a;
            }
            return k04Var;
        }
        return (k04) invokeV.objValue;
    }
}
