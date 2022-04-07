package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class eu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile du0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized du0 a() {
        InterceptResult invokeV;
        du0 du0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eu0.class) {
                if (a == null) {
                    a = new du0();
                }
                du0Var = a;
            }
            return du0Var;
        }
        return (du0) invokeV.objValue;
    }
}
