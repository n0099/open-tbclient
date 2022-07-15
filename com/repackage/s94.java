package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.za4;
import java.util.List;
/* loaded from: classes7.dex */
public class s94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ka4 ka4Var, @NonNull List<ha4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ka4Var, list) == null) {
            for (ha4<T> ha4Var : list) {
                ka4Var.c(fa4.b().a(ha4Var));
            }
        }
    }

    @NonNull
    public static ka4 b(za4 za4Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, za4Var, a84Var)) == null) {
            List<ha4<za4.a>> f = ja4.f(za4Var.a, a84Var);
            ka4 ka4Var = new ka4(a84Var);
            for (ha4<za4.a> ha4Var : f) {
                ka4Var.c(fa4.b().a(ha4Var));
            }
            return ka4Var;
        }
        return (ka4) invokeLL.objValue;
    }

    public static synchronized void c(ab4 ab4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ab4Var, a84Var) == null) {
            synchronized (s94.class) {
                ha4<c94> d = ja4.d(ab4Var.d, a84Var);
                ha4<e94> g = ja4.g(ab4Var.a, a84Var);
                ha4<a94> c = ja4.c(ab4Var.f, a84Var);
                List<ha4<f94>> h = ja4.h(ab4Var.b, a84Var);
                List<ha4<g94>> e = ja4.e(ab4Var.c, a84Var);
                ka4 ka4Var = new ka4(a84Var);
                ka4Var.c(fa4.b().a(d));
                ka4Var.c(fa4.b().a(g));
                ka4Var.c(fa4.b().a(c));
                a(ka4Var, h);
                a(ka4Var, e);
                ka4Var.e();
            }
        }
    }

    public static synchronized void d(bb4 bb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bb4Var, a84Var) == null) {
            synchronized (s94.class) {
                ha4<g94> i = ja4.i(bb4Var.a, a84Var);
                ka4 ka4Var = new ka4(a84Var);
                ka4Var.c(fa4.b().a(i));
                ka4Var.e();
            }
        }
    }

    public static synchronized void e(cb4 cb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cb4Var, a84Var) == null) {
            synchronized (s94.class) {
                List<ha4<f94>> h = ja4.h(cb4Var.a, a84Var);
                ka4 ka4Var = new ka4(a84Var);
                for (ha4<f94> ha4Var : h) {
                    ka4Var.c(fa4.b().a(ha4Var));
                }
                ka4Var.e();
            }
        }
    }

    public static synchronized void f(xc4 xc4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xc4Var, a84Var) == null) {
            synchronized (s94.class) {
                ha4<c94> d = ja4.d(xc4Var.b, a84Var);
                ha4<c94> d2 = ja4.d(xc4Var.a, a84Var);
                ha4<a94> c = ja4.c(xc4Var.c, a84Var);
                ka4 ka4Var = new ka4(a84Var);
                if (d != null) {
                    ka4Var.c(fa4.b().a(d));
                }
                if (d2 != null) {
                    ka4Var.c(fa4.b().a(d2));
                }
                if (c != null) {
                    ka4Var.c(fa4.b().a(c));
                }
                if (xc4Var.d != null) {
                    for (h94 h94Var : xc4Var.d) {
                        ha4<h94> j = ja4.j(h94Var, a84Var);
                        if (j != null) {
                            ka4Var.c(fa4.b().a(j));
                        }
                    }
                }
                if (xc4Var.e != null) {
                    for (g94 g94Var : xc4Var.e) {
                        ha4<g94> i = ja4.i(g94Var, a84Var);
                        if (i != null) {
                            ka4Var.c(fa4.b().a(i));
                        }
                    }
                }
                ka4Var.e();
            }
        }
    }

    public static synchronized void g(List<g94> list, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, a84Var) == null) {
            synchronized (s94.class) {
                List<ha4<g94>> e = ja4.e(list, a84Var);
                ka4 ka4Var = new ka4(a84Var);
                a(ka4Var, e);
                ka4Var.e();
            }
        }
    }
}
