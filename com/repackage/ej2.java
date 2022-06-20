package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ej2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dj2 a() {
        InterceptResult invokeV;
        dj2 dj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ej2.class) {
                if (a == null) {
                    a = new dj2();
                }
                dj2Var = a;
            }
            return dj2Var;
        }
        return (dj2) invokeV.objValue;
    }
}
