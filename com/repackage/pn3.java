package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile on3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized on3 a() {
        InterceptResult invokeV;
        on3 on3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pn3.class) {
                if (a == null) {
                    a = new on3();
                }
                on3Var = a;
            }
            return on3Var;
        }
        return (on3) invokeV.objValue;
    }
}
