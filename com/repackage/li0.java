package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class li0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gy0 a(@NonNull si0 si0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, si0Var)) == null) {
            gy0 gy0Var = new gy0();
            gy0Var.h(si0Var.d());
            gy0Var.n(si0Var.b);
            gy0Var.m(si0Var.c.status);
            gy0Var.j(si0Var.d);
            gy0Var.o(si0Var.g);
            File file = si0Var.h;
            if (file != null) {
                gy0Var.f(file.getAbsolutePath());
            } else {
                gy0Var.f("");
            }
            gy0Var.k((int) (si0Var.i * 1000.0f));
            gy0Var.p((int) (si0Var.j * 1000.0f));
            gy0Var.l(si0Var.l);
            gy0Var.g(si0Var.m);
            wi0 wi0Var = si0Var.p;
            if (wi0Var != null) {
                gy0Var.i(wi0.a(wi0Var));
            } else {
                gy0Var.i("");
            }
            ti0 ti0Var = si0Var.q;
            if (ti0Var != null) {
                gy0Var.d(ti0.a(ti0Var));
            } else {
                gy0Var.d("");
            }
            vi0 vi0Var = si0Var.r;
            if (vi0Var != null) {
                gy0Var.e(vi0.a(vi0Var));
            } else {
                gy0Var.e("");
            }
            return gy0Var;
        }
        return (gy0) invokeL.objValue;
    }
}
