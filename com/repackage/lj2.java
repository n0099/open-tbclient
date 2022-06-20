package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kj2 a() {
        InterceptResult invokeV;
        kj2 kj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lj2.class) {
                if (a == null) {
                    a = new kj2();
                }
                kj2Var = a;
            }
            return kj2Var;
        }
        return (kj2) invokeV.objValue;
    }
}
