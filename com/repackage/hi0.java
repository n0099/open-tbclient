package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class hi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fy0 a(@NonNull oi0 oi0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, oi0Var)) == null) {
            fy0 fy0Var = new fy0();
            fy0Var.h(oi0Var.e());
            fy0Var.n(oi0Var.b);
            fy0Var.m(oi0Var.c.status);
            fy0Var.j(oi0Var.d);
            fy0Var.o(oi0Var.g);
            File file = oi0Var.h;
            if (file != null) {
                fy0Var.f(file.getAbsolutePath());
            } else {
                fy0Var.f("");
            }
            fy0Var.k((int) (oi0Var.i * 1000.0f));
            fy0Var.p((int) (oi0Var.j * 1000.0f));
            fy0Var.l(oi0Var.l);
            fy0Var.g(oi0Var.m);
            si0 si0Var = oi0Var.p;
            if (si0Var != null) {
                fy0Var.i(si0.a(si0Var));
            } else {
                fy0Var.i("");
            }
            pi0 pi0Var = oi0Var.q;
            if (pi0Var != null) {
                fy0Var.d(pi0.a(pi0Var));
            } else {
                fy0Var.d("");
            }
            ri0 ri0Var = oi0Var.r;
            if (ri0Var != null) {
                fy0Var.e(ri0.a(ri0Var));
            } else {
                fy0Var.e("");
            }
            return fy0Var;
        }
        return (fy0) invokeL.objValue;
    }
}
