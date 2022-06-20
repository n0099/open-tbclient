package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized al3 a() {
        InterceptResult invokeV;
        al3 al3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bl3.class) {
                if (a == null) {
                    a = new al3();
                }
                al3Var = a;
            }
            return al3Var;
        }
        return (al3) invokeV.objValue;
    }
}
