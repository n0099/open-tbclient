package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class f49 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e49 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e49 a() {
        InterceptResult invokeV;
        e49 e49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f49.class) {
                if (a == null) {
                    a = new e49();
                }
                e49Var = a;
            }
            return e49Var;
        }
        return (e49) invokeV.objValue;
    }
}
