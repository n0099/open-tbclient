package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized al5 a() {
        InterceptResult invokeV;
        al5 al5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bl5.class) {
                if (a == null) {
                    a = new al5();
                }
                al5Var = a;
            }
            return al5Var;
        }
        return (al5) invokeV.objValue;
    }
}
