package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t14 a() {
        InterceptResult invokeV;
        t14 t14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u14.class) {
                if (a == null) {
                    a = new t14();
                }
                t14Var = a;
            }
            return t14Var;
        }
        return (t14) invokeV.objValue;
    }
}
