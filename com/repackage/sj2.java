package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rj2 a() {
        InterceptResult invokeV;
        rj2 rj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sj2.class) {
                if (a == null) {
                    a = new rj2();
                }
                rj2Var = a;
            }
            return rj2Var;
        }
        return (rj2) invokeV.objValue;
    }
}
