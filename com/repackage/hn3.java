package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gn3 a() {
        InterceptResult invokeV;
        gn3 gn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hn3.class) {
                if (a == null) {
                    a = new gn3();
                }
                gn3Var = a;
            }
            return gn3Var;
        }
        return (gn3) invokeV.objValue;
    }
}
