package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.el2;
/* loaded from: classes6.dex */
public class ey2 extends j73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            el2.a W = g03.K().q().W();
            k73 k73Var = new k73();
            k73Var.b = str;
            k73Var.a = a73.n(W.G());
            k73Var.f = W.H();
            k73Var.c = W.T();
            a73.x("1045", k73Var);
        }
    }
}
