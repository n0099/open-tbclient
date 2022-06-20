package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ka4;
import java.util.List;
/* loaded from: classes5.dex */
public class d94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull v94 v94Var, @NonNull List<s94<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, v94Var, list) == null) {
            for (s94<T> s94Var : list) {
                v94Var.c(q94.b().a(s94Var));
            }
        }
    }

    @NonNull
    public static v94 b(ka4 ka4Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ka4Var, l74Var)) == null) {
            List<s94<ka4.a>> f = u94.f(ka4Var.a, l74Var);
            v94 v94Var = new v94(l74Var);
            for (s94<ka4.a> s94Var : f) {
                v94Var.c(q94.b().a(s94Var));
            }
            return v94Var;
        }
        return (v94) invokeLL.objValue;
    }

    public static synchronized void c(la4 la4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, la4Var, l74Var) == null) {
            synchronized (d94.class) {
                s94<n84> d = u94.d(la4Var.d, l74Var);
                s94<p84> g = u94.g(la4Var.a, l74Var);
                s94<l84> c = u94.c(la4Var.f, l74Var);
                List<s94<q84>> h = u94.h(la4Var.b, l74Var);
                List<s94<r84>> e = u94.e(la4Var.c, l74Var);
                v94 v94Var = new v94(l74Var);
                v94Var.c(q94.b().a(d));
                v94Var.c(q94.b().a(g));
                v94Var.c(q94.b().a(c));
                a(v94Var, h);
                a(v94Var, e);
                v94Var.e();
            }
        }
    }

    public static synchronized void d(ma4 ma4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ma4Var, l74Var) == null) {
            synchronized (d94.class) {
                s94<r84> i = u94.i(ma4Var.a, l74Var);
                v94 v94Var = new v94(l74Var);
                v94Var.c(q94.b().a(i));
                v94Var.e();
            }
        }
    }

    public static synchronized void e(na4 na4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, na4Var, l74Var) == null) {
            synchronized (d94.class) {
                List<s94<q84>> h = u94.h(na4Var.a, l74Var);
                v94 v94Var = new v94(l74Var);
                for (s94<q84> s94Var : h) {
                    v94Var.c(q94.b().a(s94Var));
                }
                v94Var.e();
            }
        }
    }

    public static synchronized void f(ic4 ic4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ic4Var, l74Var) == null) {
            synchronized (d94.class) {
                s94<n84> d = u94.d(ic4Var.b, l74Var);
                s94<n84> d2 = u94.d(ic4Var.a, l74Var);
                s94<l84> c = u94.c(ic4Var.c, l74Var);
                v94 v94Var = new v94(l74Var);
                if (d != null) {
                    v94Var.c(q94.b().a(d));
                }
                if (d2 != null) {
                    v94Var.c(q94.b().a(d2));
                }
                if (c != null) {
                    v94Var.c(q94.b().a(c));
                }
                if (ic4Var.d != null) {
                    for (s84 s84Var : ic4Var.d) {
                        s94<s84> j = u94.j(s84Var, l74Var);
                        if (j != null) {
                            v94Var.c(q94.b().a(j));
                        }
                    }
                }
                if (ic4Var.e != null) {
                    for (r84 r84Var : ic4Var.e) {
                        s94<r84> i = u94.i(r84Var, l74Var);
                        if (i != null) {
                            v94Var.c(q94.b().a(i));
                        }
                    }
                }
                v94Var.e();
            }
        }
    }

    public static synchronized void g(List<r84> list, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, l74Var) == null) {
            synchronized (d94.class) {
                List<s94<r84>> e = u94.e(list, l74Var);
                v94 v94Var = new v94(l74Var);
                a(v94Var, e);
                v94Var.e();
            }
        }
    }
}
