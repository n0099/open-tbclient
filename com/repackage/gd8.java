package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fd8 a() {
        InterceptResult invokeV;
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gd8.class) {
                if (a == null) {
                    a = new fd8();
                }
                fd8Var = a;
            }
            return fd8Var;
        }
        return (fd8) invokeV.objValue;
    }
}
