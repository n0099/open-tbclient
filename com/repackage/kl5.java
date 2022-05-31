package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jl5 a() {
        InterceptResult invokeV;
        jl5 jl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kl5.class) {
                if (a == null) {
                    a = new jl5();
                }
                jl5Var = a;
            }
            return jl5Var;
        }
        return (jl5) invokeV.objValue;
    }
}
