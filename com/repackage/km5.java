package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class km5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jm5 a() {
        InterceptResult invokeV;
        jm5 jm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (km5.class) {
                if (a == null) {
                    a = new jm5();
                }
                jm5Var = a;
            }
            return jm5Var;
        }
        return (jm5) invokeV.objValue;
    }
}
