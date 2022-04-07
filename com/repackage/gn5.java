package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fn5 a() {
        InterceptResult invokeV;
        fn5 fn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gn5.class) {
                if (a == null) {
                    a = new fn5();
                }
                fn5Var = a;
            }
            return fn5Var;
        }
        return (fn5) invokeV.objValue;
    }
}
