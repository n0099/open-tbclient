package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class et0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dt0 a() {
        InterceptResult invokeV;
        dt0 dt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (et0.class) {
                if (a == null) {
                    a = new dt0();
                }
                dt0Var = a;
            }
            return dt0Var;
        }
        return (dt0) invokeV.objValue;
    }
}
