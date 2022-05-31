package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ub8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ub8 a() {
        InterceptResult invokeV;
        ub8 ub8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vb8.class) {
                if (a == null) {
                    a = new ub8();
                }
                ub8Var = a;
            }
            return ub8Var;
        }
        return (ub8) invokeV.objValue;
    }
}
