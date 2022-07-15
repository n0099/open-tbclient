package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class il3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hl3 a() {
        InterceptResult invokeV;
        hl3 hl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (il3.class) {
                if (a == null) {
                    a = new hl3();
                }
                hl3Var = a;
            }
            return hl3Var;
        }
        return (hl3) invokeV.objValue;
    }
}
