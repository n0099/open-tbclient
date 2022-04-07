package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mu0 a() {
        InterceptResult invokeV;
        mu0 mu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nu0.class) {
                if (a == null) {
                    a = new mu0();
                }
                mu0Var = a;
            }
            return mu0Var;
        }
        return (mu0) invokeV.objValue;
    }
}
