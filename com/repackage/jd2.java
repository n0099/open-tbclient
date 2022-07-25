package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hd2 a(SwanAppActivity swanAppActivity, i03 i03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, i03Var)) == null) {
            if (i03Var == null || !i03Var.I()) {
                return null;
            }
            int k = i03Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return qj2.i().n(swanAppActivity, i03Var.b);
            }
            return new kd2(swanAppActivity, i03Var.b);
        }
        return (hd2) invokeLL.objValue;
    }
}
