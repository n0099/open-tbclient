package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fn3 a() {
        InterceptResult invokeV;
        fn3 fn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gn3.class) {
                if (a == null) {
                    a = new fn3();
                }
                fn3Var = a;
            }
            return fn3Var;
        }
        return (fn3) invokeV.objValue;
    }
}
