package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y04 a() {
        InterceptResult invokeV;
        y04 y04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z04.class) {
                if (a == null) {
                    a = new y04();
                }
                y04Var = a;
            }
            return y04Var;
        }
        return (y04) invokeV.objValue;
    }
}
