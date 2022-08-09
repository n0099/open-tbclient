package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yo5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xo5 a() {
        InterceptResult invokeV;
        xo5 xo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yo5.class) {
                if (a == null) {
                    a = new xo5();
                }
                xo5Var = a;
            }
            return xo5Var;
        }
        return (xo5) invokeV.objValue;
    }
}
