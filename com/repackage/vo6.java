package com.repackage;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uo6 a(zo6 zo6Var, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zo6Var, intent)) == null) {
            int intExtra = intent.getIntExtra("transition_type", 0);
            if (intExtra == 1) {
                return new ap6(zo6Var, intent);
            }
            if (intExtra == 2) {
                return new to6(zo6Var, intent);
            }
            return null;
        }
        return (uo6) invokeLL.objValue;
    }
}
