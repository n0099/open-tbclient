package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.rb4;
import java.util.List;
/* loaded from: classes6.dex */
public class ka4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull cb4 cb4Var, @NonNull List<za4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cb4Var, list) == null) {
            for (za4<T> za4Var : list) {
                cb4Var.c(xa4.b().a(za4Var));
            }
        }
    }

    @NonNull
    public static cb4 b(rb4 rb4Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rb4Var, s84Var)) == null) {
            List<za4<rb4.a>> f = bb4.f(rb4Var.a, s84Var);
            cb4 cb4Var = new cb4(s84Var);
            for (za4<rb4.a> za4Var : f) {
                cb4Var.c(xa4.b().a(za4Var));
            }
            return cb4Var;
        }
        return (cb4) invokeLL.objValue;
    }

    public static synchronized void c(sb4 sb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sb4Var, s84Var) == null) {
            synchronized (ka4.class) {
                za4<u94> d = bb4.d(sb4Var.d, s84Var);
                za4<w94> g = bb4.g(sb4Var.a, s84Var);
                za4<s94> c = bb4.c(sb4Var.f, s84Var);
                List<za4<x94>> h = bb4.h(sb4Var.b, s84Var);
                List<za4<y94>> e = bb4.e(sb4Var.c, s84Var);
                cb4 cb4Var = new cb4(s84Var);
                cb4Var.c(xa4.b().a(d));
                cb4Var.c(xa4.b().a(g));
                cb4Var.c(xa4.b().a(c));
                a(cb4Var, h);
                a(cb4Var, e);
                cb4Var.e();
            }
        }
    }

    public static synchronized void d(tb4 tb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tb4Var, s84Var) == null) {
            synchronized (ka4.class) {
                za4<y94> i = bb4.i(tb4Var.a, s84Var);
                cb4 cb4Var = new cb4(s84Var);
                cb4Var.c(xa4.b().a(i));
                cb4Var.e();
            }
        }
    }

    public static synchronized void e(ub4 ub4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ub4Var, s84Var) == null) {
            synchronized (ka4.class) {
                List<za4<x94>> h = bb4.h(ub4Var.a, s84Var);
                cb4 cb4Var = new cb4(s84Var);
                for (za4<x94> za4Var : h) {
                    cb4Var.c(xa4.b().a(za4Var));
                }
                cb4Var.e();
            }
        }
    }

    public static synchronized void f(pd4 pd4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pd4Var, s84Var) == null) {
            synchronized (ka4.class) {
                za4<u94> d = bb4.d(pd4Var.b, s84Var);
                za4<u94> d2 = bb4.d(pd4Var.a, s84Var);
                za4<s94> c = bb4.c(pd4Var.c, s84Var);
                cb4 cb4Var = new cb4(s84Var);
                if (d != null) {
                    cb4Var.c(xa4.b().a(d));
                }
                if (d2 != null) {
                    cb4Var.c(xa4.b().a(d2));
                }
                if (c != null) {
                    cb4Var.c(xa4.b().a(c));
                }
                if (pd4Var.d != null) {
                    for (z94 z94Var : pd4Var.d) {
                        za4<z94> j = bb4.j(z94Var, s84Var);
                        if (j != null) {
                            cb4Var.c(xa4.b().a(j));
                        }
                    }
                }
                if (pd4Var.e != null) {
                    for (y94 y94Var : pd4Var.e) {
                        za4<y94> i = bb4.i(y94Var, s84Var);
                        if (i != null) {
                            cb4Var.c(xa4.b().a(i));
                        }
                    }
                }
                cb4Var.e();
            }
        }
    }

    public static synchronized void g(List<y94> list, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, s84Var) == null) {
            synchronized (ka4.class) {
                List<za4<y94>> e = bb4.e(list, s84Var);
                cb4 cb4Var = new cb4(s84Var);
                a(cb4Var, e);
                cb4Var.e();
            }
        }
    }
}
