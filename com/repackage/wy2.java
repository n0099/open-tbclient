package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wl2;
/* loaded from: classes7.dex */
public class wy2 extends b83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            wl2.a W = y03.K().q().W();
            c83 c83Var = new c83();
            c83Var.b = str;
            c83Var.a = s73.n(W.G());
            c83Var.f = W.H();
            c83Var.c = W.T();
            s73.x("1045", c83Var);
        }
    }
}
