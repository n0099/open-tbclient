package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class bi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tx0 a(@NonNull ii0 ii0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ii0Var)) == null) {
            tx0 tx0Var = new tx0();
            tx0Var.h(ii0Var.d());
            tx0Var.n(ii0Var.b);
            tx0Var.m(ii0Var.c.status);
            tx0Var.j(ii0Var.d);
            tx0Var.o(ii0Var.g);
            File file = ii0Var.h;
            if (file != null) {
                tx0Var.f(file.getAbsolutePath());
            } else {
                tx0Var.f("");
            }
            tx0Var.k((int) (ii0Var.i * 1000.0f));
            tx0Var.p((int) (ii0Var.j * 1000.0f));
            tx0Var.l(ii0Var.l);
            tx0Var.g(ii0Var.m);
            li0 li0Var = ii0Var.p;
            if (li0Var != null) {
                tx0Var.i(li0.a(li0Var));
            } else {
                tx0Var.i("");
            }
            ji0 ji0Var = ii0Var.q;
            if (ji0Var != null) {
                tx0Var.d(ji0.a(ji0Var));
            } else {
                tx0Var.d("");
            }
            ki0 ki0Var = ii0Var.r;
            if (ki0Var != null) {
                tx0Var.e(ki0.a(ki0Var));
            } else {
                tx0Var.e("");
            }
            return tx0Var;
        }
        return (tx0) invokeL.objValue;
    }
}
