package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class at0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zs0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zs0 a() {
        InterceptResult invokeV;
        zs0 zs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (at0.class) {
                if (a == null) {
                    a = new zs0();
                }
                zs0Var = a;
            }
            return zs0Var;
        }
        return (zs0) invokeV.objValue;
    }
}
