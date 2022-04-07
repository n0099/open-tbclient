package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.gl2;
/* loaded from: classes6.dex */
public class gy2 extends l73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            gl2.a V = i03.J().r().V();
            m73 m73Var = new m73();
            m73Var.b = str;
            m73Var.a = c73.n(V.G());
            m73Var.f = V.H();
            m73Var.c = V.T();
            c73.x("1045", m73Var);
        }
    }
}
