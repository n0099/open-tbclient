package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uj2 a() {
        InterceptResult invokeV;
        uj2 uj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vj2.class) {
                if (a == null) {
                    a = new uj2();
                }
                uj2Var = a;
            }
            return uj2Var;
        }
        return (uj2) invokeV.objValue;
    }
}
