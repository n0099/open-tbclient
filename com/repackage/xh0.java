package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class xh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static px0 a(@NonNull ei0 ei0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ei0Var)) == null) {
            px0 px0Var = new px0();
            px0Var.h(ei0Var.d());
            px0Var.n(ei0Var.b);
            px0Var.m(ei0Var.c.status);
            px0Var.j(ei0Var.d);
            px0Var.o(ei0Var.g);
            File file = ei0Var.h;
            if (file != null) {
                px0Var.f(file.getAbsolutePath());
            } else {
                px0Var.f("");
            }
            px0Var.k((int) (ei0Var.i * 1000.0f));
            px0Var.p((int) (ei0Var.j * 1000.0f));
            px0Var.l(ei0Var.l);
            px0Var.g(ei0Var.m);
            hi0 hi0Var = ei0Var.p;
            if (hi0Var != null) {
                px0Var.i(hi0.a(hi0Var));
            } else {
                px0Var.i("");
            }
            fi0 fi0Var = ei0Var.q;
            if (fi0Var != null) {
                px0Var.d(fi0.a(fi0Var));
            } else {
                px0Var.d("");
            }
            gi0 gi0Var = ei0Var.r;
            if (gi0Var != null) {
                px0Var.e(gi0.a(gi0Var));
            } else {
                px0Var.e("");
            }
            return px0Var;
        }
        return (px0) invokeL.objValue;
    }
}
