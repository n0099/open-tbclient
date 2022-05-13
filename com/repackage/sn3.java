package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rn3 a() {
        InterceptResult invokeV;
        rn3 rn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sn3.class) {
                if (a == null) {
                    a = new rn3();
                }
                rn3Var = a;
            }
            return rn3Var;
        }
        return (rn3) invokeV.objValue;
    }
}
