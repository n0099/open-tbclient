package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wn5 a() {
        InterceptResult invokeV;
        wn5 wn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xn5.class) {
                if (a == null) {
                    a = new wn5();
                }
                wn5Var = a;
            }
            return wn5Var;
        }
        return (wn5) invokeV.objValue;
    }
}
