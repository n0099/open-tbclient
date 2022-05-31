package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mb8 a() {
        InterceptResult invokeV;
        mb8 mb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nb8.class) {
                if (a == null) {
                    a = new mb8();
                }
                mb8Var = a;
            }
            return mb8Var;
        }
        return (mb8) invokeV.objValue;
    }
}
