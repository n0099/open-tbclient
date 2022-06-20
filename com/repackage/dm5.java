package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cm5 a() {
        InterceptResult invokeV;
        cm5 cm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dm5.class) {
                if (a == null) {
                    a = new cm5();
                }
                cm5Var = a;
            }
            return cm5Var;
        }
        return (cm5) invokeV.objValue;
    }
}
