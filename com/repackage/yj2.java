package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xj2 a() {
        InterceptResult invokeV;
        xj2 xj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yj2.class) {
                if (a == null) {
                    a = new xj2();
                }
                xj2Var = a;
            }
            return xj2Var;
        }
        return (xj2) invokeV.objValue;
    }
}
