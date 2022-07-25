package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qs3 a() {
        InterceptResult invokeV;
        qs3 qs3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rs3.class) {
                if (a == null) {
                    a = new qs3();
                }
                qs3Var = a;
            }
            return qs3Var;
        }
        return (qs3) invokeV.objValue;
    }
}
