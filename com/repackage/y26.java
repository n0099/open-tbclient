package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x26 a() {
        InterceptResult invokeV;
        x26 x26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y26.class) {
                if (a == null) {
                    a = new x26();
                }
                x26Var = a;
            }
            return x26Var;
        }
        return (x26) invokeV.objValue;
    }
}
