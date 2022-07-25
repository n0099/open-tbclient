package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c14 a() {
        InterceptResult invokeV;
        c14 c14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d14.class) {
                if (a == null) {
                    a = new c14();
                }
                c14Var = a;
            }
            return c14Var;
        }
        return (c14) invokeV.objValue;
    }
}
