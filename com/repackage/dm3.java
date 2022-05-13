package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cm3 a() {
        InterceptResult invokeV;
        cm3 cm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dm3.class) {
                if (a == null) {
                    a = new cm3();
                }
                cm3Var = a;
            }
            return cm3Var;
        }
        return (cm3) invokeV.objValue;
    }
}
