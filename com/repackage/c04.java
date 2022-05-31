package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b04 a() {
        InterceptResult invokeV;
        b04 b04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c04.class) {
                if (a == null) {
                    a = new b04();
                }
                b04Var = a;
            }
            return b04Var;
        }
        return (b04) invokeV.objValue;
    }
}
