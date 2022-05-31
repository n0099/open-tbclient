package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ws0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vs0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vs0 a() {
        InterceptResult invokeV;
        vs0 vs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ws0.class) {
                if (a == null) {
                    a = new vs0();
                }
                vs0Var = a;
            }
            return vs0Var;
        }
        return (vs0) invokeV.objValue;
    }
}
