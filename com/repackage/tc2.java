package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rc2 a(SwanAppActivity swanAppActivity, sz2 sz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, sz2Var)) == null) {
            if (sz2Var == null || !sz2Var.I()) {
                return null;
            }
            int l = sz2Var.l();
            if (l != 0) {
                if (l != 1) {
                    return null;
                }
                return aj2.i().o(swanAppActivity, sz2Var.b);
            }
            return new uc2(swanAppActivity, sz2Var.b);
        }
        return (rc2) invokeLL.objValue;
    }
}
