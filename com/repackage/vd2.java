package com.repackage;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static td2 a(SwanAppActivity swanAppActivity, u03 u03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, u03Var)) == null) {
            if (u03Var == null || !u03Var.H()) {
                return null;
            }
            int l = u03Var.l();
            if (l != 0) {
                if (l != 1) {
                    return null;
                }
                return ck2.i().o(swanAppActivity, u03Var.b);
            }
            return new wd2(swanAppActivity, u03Var.b);
        }
        return (td2) invokeLL.objValue;
    }
}
