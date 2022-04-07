package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o44 a() {
        InterceptResult invokeV;
        o44 o44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p44.class) {
                if (a == null) {
                    a = new o44();
                }
                o44Var = a;
            }
            return o44Var;
        }
        return (o44) invokeV.objValue;
    }
}
