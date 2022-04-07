package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y39 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x39 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x39 a() {
        InterceptResult invokeV;
        x39 x39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y39.class) {
                if (a == null) {
                    a = new x39();
                }
                x39Var = a;
            }
            return x39Var;
        }
        return (x39) invokeV.objValue;
    }
}
