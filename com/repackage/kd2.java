package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static id2 a(SwanAppActivity swanAppActivity, j03 j03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, j03Var)) == null) {
            if (j03Var == null || !j03Var.H()) {
                return null;
            }
            int l = j03Var.l();
            if (l != 0) {
                if (l != 1) {
                    return null;
                }
                return rj2.i().o(swanAppActivity, j03Var.b);
            }
            return new ld2(swanAppActivity, j03Var.b);
        }
        return (id2) invokeLL.objValue;
    }
}
