package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x80 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x80 a() {
        InterceptResult invokeV;
        x80 x80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y80.class) {
                if (a == null) {
                    a = new x80();
                }
                x80Var = a;
            }
            return x80Var;
        }
        return (x80) invokeV.objValue;
    }
}
