package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jl3 a() {
        InterceptResult invokeV;
        jl3 jl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kl3.class) {
                if (a == null) {
                    a = new jl3();
                }
                jl3Var = a;
            }
            return jl3Var;
        }
        return (jl3) invokeV.objValue;
    }
}
