package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zi2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zi2 a() {
        InterceptResult invokeV;
        zi2 zi2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aj2.class) {
                if (a == null) {
                    a = new zi2();
                }
                zi2Var = a;
            }
            return zi2Var;
        }
        return (zi2) invokeV.objValue;
    }
}
