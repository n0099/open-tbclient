package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile km3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized km3 a() {
        InterceptResult invokeV;
        km3 km3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lm3.class) {
                if (a == null) {
                    a = new km3();
                }
                km3Var = a;
            }
            return km3Var;
        }
        return (km3) invokeV.objValue;
    }
}
