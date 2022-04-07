package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kq3 a() {
        InterceptResult invokeV;
        kq3 kq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lq3.class) {
                if (a == null) {
                    a = new kq3();
                }
                kq3Var = a;
            }
            return kq3Var;
        }
        return (kq3) invokeV.objValue;
    }
}
