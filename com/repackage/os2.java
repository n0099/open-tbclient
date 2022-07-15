package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class os2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ns2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ns2 a() {
        InterceptResult invokeV;
        ns2 ns2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (os2.class) {
                if (a == null) {
                    a = new ns2();
                }
                ns2Var = a;
            }
            return ns2Var;
        }
        return (ns2) invokeV.objValue;
    }
}
