package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gn5 a() {
        InterceptResult invokeV;
        gn5 gn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hn5.class) {
                if (a == null) {
                    a = new gn5();
                }
                gn5Var = a;
            }
            return gn5Var;
        }
        return (gn5) invokeV.objValue;
    }
}
