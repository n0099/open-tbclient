package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class d24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c24 a() {
        InterceptResult invokeV;
        c24 c24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d24.class) {
                if (a == null) {
                    a = new c24();
                }
                c24Var = a;
            }
            return c24Var;
        }
        return (c24) invokeV.objValue;
    }
}
