package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ll3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kl3 a() {
        InterceptResult invokeV;
        kl3 kl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ll3.class) {
                if (a == null) {
                    a = new kl3();
                }
                kl3Var = a;
            }
            return kl3Var;
        }
        return (kl3) invokeV.objValue;
    }
}
