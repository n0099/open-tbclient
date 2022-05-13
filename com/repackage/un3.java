package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class un3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tn3 a() {
        InterceptResult invokeV;
        tn3 tn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (un3.class) {
                if (a == null) {
                    a = new tn3();
                }
                tn3Var = a;
            }
            return tn3Var;
        }
        return (tn3) invokeV.objValue;
    }
}
