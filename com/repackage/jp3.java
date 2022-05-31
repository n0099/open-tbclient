package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ip3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ip3 a() {
        InterceptResult invokeV;
        ip3 ip3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jp3.class) {
                if (a == null) {
                    a = new ip3();
                }
                ip3Var = a;
            }
            return ip3Var;
        }
        return (ip3) invokeV.objValue;
    }
}
