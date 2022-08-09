package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rk2 a() {
        InterceptResult invokeV;
        rk2 rk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sk2.class) {
                if (a == null) {
                    a = new rk2();
                }
                rk2Var = a;
            }
            return rk2Var;
        }
        return (rk2) invokeV.objValue;
    }
}
