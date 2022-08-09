package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ip5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ip5 a() {
        InterceptResult invokeV;
        ip5 ip5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jp5.class) {
                if (a == null) {
                    a = new ip5();
                }
                ip5Var = a;
            }
            return ip5Var;
        }
        return (ip5) invokeV.objValue;
    }
}
