package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ps2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ps2 a() {
        InterceptResult invokeV;
        ps2 ps2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qs2.class) {
                if (a == null) {
                    a = new ps2();
                }
                ps2Var = a;
            }
            return ps2Var;
        }
        return (ps2) invokeV.objValue;
    }
}
