package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ok2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nk2 a() {
        InterceptResult invokeV;
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ok2.class) {
                if (a == null) {
                    a = new nk2();
                }
                nk2Var = a;
            }
            return nk2Var;
        }
        return (nk2) invokeV.objValue;
    }
}
