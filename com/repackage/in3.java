package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class in3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hn3 a() {
        InterceptResult invokeV;
        hn3 hn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (in3.class) {
                if (a == null) {
                    a = new hn3();
                }
                hn3Var = a;
            }
            return hn3Var;
        }
        return (hn3) invokeV.objValue;
    }
}
