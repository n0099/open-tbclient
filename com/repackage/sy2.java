package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.rl2;
/* loaded from: classes7.dex */
public class sy2 extends w73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            rl2.a V = t03.J().r().V();
            x73 x73Var = new x73();
            x73Var.b = str;
            x73Var.a = n73.n(V.G());
            x73Var.f = V.H();
            x73Var.c = V.T();
            n73.x("1088", x73Var);
        }
    }
}
