package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a39 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z29 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z29 a() {
        InterceptResult invokeV;
        z29 z29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a39.class) {
                if (a == null) {
                    a = new z29();
                }
                z29Var = a;
            }
            return z29Var;
        }
        return (z29) invokeV.objValue;
    }
}
