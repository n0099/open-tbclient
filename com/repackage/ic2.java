package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ic2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gc2 a(SwanAppActivity swanAppActivity, hz2 hz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, hz2Var)) == null) {
            if (hz2Var == null || !hz2Var.H()) {
                return null;
            }
            int l = hz2Var.l();
            if (l != 0) {
                if (l != 1) {
                    return null;
                }
                return pi2.i().o(swanAppActivity, hz2Var.b);
            }
            return new jc2(swanAppActivity, hz2Var.b);
        }
        return (gc2) invokeLL.objValue;
    }
}
