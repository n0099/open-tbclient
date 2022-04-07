package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ln5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kn5 a() {
        InterceptResult invokeV;
        kn5 kn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ln5.class) {
                if (a == null) {
                    a = new kn5();
                }
                kn5Var = a;
            }
            return kn5Var;
        }
        return (kn5) invokeV.objValue;
    }
}
