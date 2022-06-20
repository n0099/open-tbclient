package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k09 a() {
        InterceptResult invokeV;
        k09 k09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l09.class) {
                if (a == null) {
                    a = new k09();
                }
                k09Var = a;
            }
            return k09Var;
        }
        return (k09) invokeV.objValue;
    }
}
