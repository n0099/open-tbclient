package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cj3 a() {
        InterceptResult invokeV;
        cj3 cj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dj3.class) {
                if (a == null) {
                    a = new cj3();
                }
                cj3Var = a;
            }
            return cj3Var;
        }
        return (cj3) invokeV.objValue;
    }
}
