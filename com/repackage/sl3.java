package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rl3 a() {
        InterceptResult invokeV;
        rl3 rl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sl3.class) {
                if (a == null) {
                    a = new rl3();
                }
                rl3Var = a;
            }
            return rl3Var;
        }
        return (rl3) invokeV.objValue;
    }
}
