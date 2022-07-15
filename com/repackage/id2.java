package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class id2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gd2 a(SwanAppActivity swanAppActivity, h03 h03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, h03Var)) == null) {
            if (h03Var == null || !h03Var.I()) {
                return null;
            }
            int k = h03Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return pj2.i().n(swanAppActivity, h03Var.b);
            }
            return new jd2(swanAppActivity, h03Var.b);
        }
        return (gd2) invokeLL.objValue;
    }
}
