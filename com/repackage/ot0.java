package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ot0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nt0 a() {
        InterceptResult invokeV;
        nt0 nt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ot0.class) {
                if (a == null) {
                    a = new nt0();
                }
                nt0Var = a;
            }
            return nt0Var;
        }
        return (nt0) invokeV.objValue;
    }
}
