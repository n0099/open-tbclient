package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eg3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dg3 a() {
        InterceptResult invokeV;
        dg3 dg3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eg3.class) {
                if (a == null) {
                    a = new dg3();
                }
                dg3Var = a;
            }
            return dg3Var;
        }
        return (dg3) invokeV.objValue;
    }
}
