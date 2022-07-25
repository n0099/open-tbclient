package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wj2 a() {
        InterceptResult invokeV;
        wj2 wj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xj2.class) {
                if (a == null) {
                    a = new wj2();
                }
                wj2Var = a;
            }
            return wj2Var;
        }
        return (wj2) invokeV.objValue;
    }
}
