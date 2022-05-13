package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ej3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dj3 a() {
        InterceptResult invokeV;
        dj3 dj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ej3.class) {
                if (a == null) {
                    a = new dj3();
                }
                dj3Var = a;
            }
            return dj3Var;
        }
        return (dj3) invokeV.objValue;
    }
}
