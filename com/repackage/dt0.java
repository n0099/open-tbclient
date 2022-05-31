package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ct0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ct0 a() {
        InterceptResult invokeV;
        ct0 ct0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dt0.class) {
                if (a == null) {
                    a = new ct0();
                }
                ct0Var = a;
            }
            return ct0Var;
        }
        return (ct0) invokeV.objValue;
    }
}
