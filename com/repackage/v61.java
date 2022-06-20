package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class v61 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u61 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u61 a() {
        InterceptResult invokeV;
        u61 u61Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v61.class) {
                if (a == null) {
                    a = new u61();
                }
                u61Var = a;
            }
            return u61Var;
        }
        return (u61) invokeV.objValue;
    }
}
