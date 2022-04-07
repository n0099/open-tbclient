package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t44 a() {
        InterceptResult invokeV;
        t44 t44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u44.class) {
                if (a == null) {
                    a = new t44();
                }
                t44Var = a;
            }
            return t44Var;
        }
        return (t44) invokeV.objValue;
    }
}
