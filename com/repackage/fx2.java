package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
/* loaded from: classes6.dex */
public class fx2 extends j63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            ek2.a V = gz2.J().r().V();
            k63 k63Var = new k63();
            k63Var.b = str;
            k63Var.a = a63.n(V.G());
            k63Var.f = V.H();
            k63Var.c = V.T();
            a63.x("1088", k63Var);
        }
    }
}
