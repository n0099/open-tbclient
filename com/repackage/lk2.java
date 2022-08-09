package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kk2 a() {
        InterceptResult invokeV;
        kk2 kk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lk2.class) {
                if (a == null) {
                    a = new kk2();
                }
                kk2Var = a;
            }
            return kk2Var;
        }
        return (kk2) invokeV.objValue;
    }
}
