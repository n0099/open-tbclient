package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ae2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yd2 a(SwanAppActivity swanAppActivity, z03 z03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, z03Var)) == null) {
            if (z03Var == null || !z03Var.I()) {
                return null;
            }
            int k = z03Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return hk2.i().n(swanAppActivity, z03Var.b);
            }
            return new be2(swanAppActivity, z03Var.b);
        }
        return (yd2) invokeLL.objValue;
    }
}
