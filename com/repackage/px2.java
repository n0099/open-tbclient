package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.pk2;
/* loaded from: classes6.dex */
public class px2 extends u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            pk2.a W = rz2.K().r().W();
            v63 v63Var = new v63();
            v63Var.b = str;
            v63Var.a = l63.n(W.G());
            v63Var.f = W.H();
            v63Var.c = W.T();
            l63.x("1045", v63Var);
        }
    }
}
