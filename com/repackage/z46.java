package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y46 a() {
        InterceptResult invokeV;
        y46 y46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z46.class) {
                if (a == null) {
                    a = new y46();
                }
                y46Var = a;
            }
            return y46Var;
        }
        return (y46) invokeV.objValue;
    }
}
