package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class in5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hn5 a() {
        InterceptResult invokeV;
        hn5 hn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (in5.class) {
                if (a == null) {
                    a = new hn5();
                }
                hn5Var = a;
            }
            return hn5Var;
        }
        return (hn5) invokeV.objValue;
    }
}
