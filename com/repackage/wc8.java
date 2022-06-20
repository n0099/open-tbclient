package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wc8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vc8 a() {
        InterceptResult invokeV;
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wc8.class) {
                if (a == null) {
                    a = new vc8();
                }
                vc8Var = a;
            }
            return vc8Var;
        }
        return (vc8) invokeV.objValue;
    }
}
