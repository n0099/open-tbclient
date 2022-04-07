package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t24 a() {
        InterceptResult invokeV;
        t24 t24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u24.class) {
                if (a == null) {
                    a = new t24();
                }
                t24Var = a;
            }
            return t24Var;
        }
        return (t24) invokeV.objValue;
    }
}
