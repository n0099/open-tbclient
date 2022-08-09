package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wn3 a() {
        InterceptResult invokeV;
        wn3 wn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xn3.class) {
                if (a == null) {
                    a = new wn3();
                }
                wn3Var = a;
            }
            return wn3Var;
        }
        return (wn3) invokeV.objValue;
    }
}
