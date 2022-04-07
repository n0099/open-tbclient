package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pu0 a() {
        InterceptResult invokeV;
        pu0 pu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qu0.class) {
                if (a == null) {
                    a = new pu0();
                }
                pu0Var = a;
            }
            return pu0Var;
        }
        return (pu0) invokeV.objValue;
    }
}
