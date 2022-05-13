package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d34 a() {
        InterceptResult invokeV;
        d34 d34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e34.class) {
                if (a == null) {
                    a = new d34();
                }
                d34Var = a;
            }
            return d34Var;
        }
        return (d34) invokeV.objValue;
    }
}
