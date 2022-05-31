package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xk5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wk5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wk5 a() {
        InterceptResult invokeV;
        wk5 wk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xk5.class) {
                if (a == null) {
                    a = new wk5();
                }
                wk5Var = a;
            }
            return wk5Var;
        }
        return (wk5) invokeV.objValue;
    }
}
