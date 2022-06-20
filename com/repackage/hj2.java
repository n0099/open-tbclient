package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gj2 a() {
        InterceptResult invokeV;
        gj2 gj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hj2.class) {
                if (a == null) {
                    a = new gj2();
                }
                gj2Var = a;
            }
            return gj2Var;
        }
        return (gj2) invokeV.objValue;
    }
}
