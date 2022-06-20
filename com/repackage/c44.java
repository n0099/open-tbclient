package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b44 a() {
        InterceptResult invokeV;
        b44 b44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c44.class) {
                if (a == null) {
                    a = new b44();
                }
                b44Var = a;
            }
            return b44Var;
        }
        return (b44) invokeV.objValue;
    }
}
