package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a34 a() {
        InterceptResult invokeV;
        a34 a34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b34.class) {
                if (a == null) {
                    a = new a34();
                }
                a34Var = a;
            }
            return a34Var;
        }
        return (a34) invokeV.objValue;
    }
}
