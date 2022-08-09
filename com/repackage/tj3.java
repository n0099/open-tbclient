package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sj3 a() {
        InterceptResult invokeV;
        sj3 sj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tj3.class) {
                if (a == null) {
                    a = new sj3();
                }
                sj3Var = a;
            }
            return sj3Var;
        }
        return (sj3) invokeV.objValue;
    }
}
