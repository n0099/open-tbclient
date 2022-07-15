package com.repackage;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class so6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ro6 a(wo6 wo6Var, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, wo6Var, intent)) == null) {
            int intExtra = intent.getIntExtra("transition_type", 0);
            if (intExtra == 1) {
                return new xo6(wo6Var, intent);
            }
            if (intExtra == 2) {
                return new qo6(wo6Var, intent);
            }
            return null;
        }
        return (ro6) invokeLL.objValue;
    }
}
