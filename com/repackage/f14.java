package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class f14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e14 a() {
        InterceptResult invokeV;
        e14 e14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f14.class) {
                if (a == null) {
                    a = new e14();
                }
                e14Var = a;
            }
            return e14Var;
        }
        return (e14) invokeV.objValue;
    }
}
