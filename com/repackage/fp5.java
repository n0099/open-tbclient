package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ep5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ep5 a() {
        InterceptResult invokeV;
        ep5 ep5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fp5.class) {
                if (a == null) {
                    a = new ep5();
                }
                ep5Var = a;
            }
            return ep5Var;
        }
        return (ep5) invokeV.objValue;
    }
}
