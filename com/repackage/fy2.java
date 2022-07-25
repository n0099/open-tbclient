package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fl2;
/* loaded from: classes6.dex */
public class fy2 extends k73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            fl2.a W = h03.K().q().W();
            l73 l73Var = new l73();
            l73Var.b = str;
            l73Var.a = b73.n(W.G());
            l73Var.f = W.H();
            l73Var.c = W.T();
            b73.x("1045", l73Var);
        }
    }
}
