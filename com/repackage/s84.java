package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.z94;
import java.util.List;
/* loaded from: classes7.dex */
public class s84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull k94 k94Var, @NonNull List<h94<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, k94Var, list) == null) {
            for (h94<T> h94Var : list) {
                k94Var.c(f94.b().a(h94Var));
            }
        }
    }

    @NonNull
    public static k94 b(z94 z94Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, z94Var, a74Var)) == null) {
            List<h94<z94.a>> f = j94.f(z94Var.a, a74Var);
            k94 k94Var = new k94(a74Var);
            for (h94<z94.a> h94Var : f) {
                k94Var.c(f94.b().a(h94Var));
            }
            return k94Var;
        }
        return (k94) invokeLL.objValue;
    }

    public static synchronized void c(aa4 aa4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aa4Var, a74Var) == null) {
            synchronized (s84.class) {
                h94<c84> d = j94.d(aa4Var.d, a74Var);
                h94<e84> g = j94.g(aa4Var.a, a74Var);
                h94<a84> c = j94.c(aa4Var.f, a74Var);
                List<h94<f84>> h = j94.h(aa4Var.b, a74Var);
                List<h94<g84>> e = j94.e(aa4Var.c, a74Var);
                k94 k94Var = new k94(a74Var);
                k94Var.c(f94.b().a(d));
                k94Var.c(f94.b().a(g));
                k94Var.c(f94.b().a(c));
                a(k94Var, h);
                a(k94Var, e);
                k94Var.e();
            }
        }
    }

    public static synchronized void d(ba4 ba4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ba4Var, a74Var) == null) {
            synchronized (s84.class) {
                h94<g84> i = j94.i(ba4Var.a, a74Var);
                k94 k94Var = new k94(a74Var);
                k94Var.c(f94.b().a(i));
                k94Var.e();
            }
        }
    }

    public static synchronized void e(ca4 ca4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ca4Var, a74Var) == null) {
            synchronized (s84.class) {
                List<h94<f84>> h = j94.h(ca4Var.a, a74Var);
                k94 k94Var = new k94(a74Var);
                for (h94<f84> h94Var : h) {
                    k94Var.c(f94.b().a(h94Var));
                }
                k94Var.e();
            }
        }
    }

    public static synchronized void f(xb4 xb4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xb4Var, a74Var) == null) {
            synchronized (s84.class) {
                h94<c84> d = j94.d(xb4Var.b, a74Var);
                h94<c84> d2 = j94.d(xb4Var.a, a74Var);
                h94<a84> c = j94.c(xb4Var.c, a74Var);
                k94 k94Var = new k94(a74Var);
                if (d != null) {
                    k94Var.c(f94.b().a(d));
                }
                if (d2 != null) {
                    k94Var.c(f94.b().a(d2));
                }
                if (c != null) {
                    k94Var.c(f94.b().a(c));
                }
                if (xb4Var.d != null) {
                    for (h84 h84Var : xb4Var.d) {
                        h94<h84> j = j94.j(h84Var, a74Var);
                        if (j != null) {
                            k94Var.c(f94.b().a(j));
                        }
                    }
                }
                if (xb4Var.e != null) {
                    for (g84 g84Var : xb4Var.e) {
                        h94<g84> i = j94.i(g84Var, a74Var);
                        if (i != null) {
                            k94Var.c(f94.b().a(i));
                        }
                    }
                }
                k94Var.e();
            }
        }
    }

    public static synchronized void g(List<g84> list, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, a74Var) == null) {
            synchronized (s84.class) {
                List<h94<g84>> e = j94.e(list, a74Var);
                k94 k94Var = new k94(a74Var);
                a(k94Var, e);
                k94Var.e();
            }
        }
    }
}
