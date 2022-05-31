package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ok3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nk3 a() {
        InterceptResult invokeV;
        nk3 nk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ok3.class) {
                if (a == null) {
                    a = new nk3();
                }
                nk3Var = a;
            }
            return nk3Var;
        }
        return (nk3) invokeV.objValue;
    }
}
