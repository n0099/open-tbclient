package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class os0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ns0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ns0 a() {
        InterceptResult invokeV;
        ns0 ns0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (os0.class) {
                if (a == null) {
                    a = new ns0();
                }
                ns0Var = a;
            }
            return ns0Var;
        }
        return (ns0) invokeV.objValue;
    }
}
