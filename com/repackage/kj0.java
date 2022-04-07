package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class kj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static cz0 a(@NonNull rj0 rj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rj0Var)) == null) {
            cz0 cz0Var = new cz0();
            cz0Var.h(rj0Var.d());
            cz0Var.n(rj0Var.b);
            cz0Var.m(rj0Var.c.status);
            cz0Var.j(rj0Var.d);
            cz0Var.o(rj0Var.g);
            File file = rj0Var.h;
            if (file != null) {
                cz0Var.f(file.getAbsolutePath());
            } else {
                cz0Var.f("");
            }
            cz0Var.k((int) (rj0Var.i * 1000.0f));
            cz0Var.p((int) (rj0Var.j * 1000.0f));
            cz0Var.l(rj0Var.l);
            cz0Var.g(rj0Var.m);
            uj0 uj0Var = rj0Var.p;
            if (uj0Var != null) {
                cz0Var.i(uj0.a(uj0Var));
            } else {
                cz0Var.i("");
            }
            sj0 sj0Var = rj0Var.q;
            if (sj0Var != null) {
                cz0Var.d(sj0.a(sj0Var));
            } else {
                cz0Var.d("");
            }
            tj0 tj0Var = rj0Var.r;
            if (tj0Var != null) {
                cz0Var.e(tj0.a(tj0Var));
            } else {
                cz0Var.e("");
            }
            return cz0Var;
        }
        return (cz0) invokeL.objValue;
    }
}
