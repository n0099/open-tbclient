package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.mb4;
import java.util.List;
/* loaded from: classes6.dex */
public class fa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull xa4 xa4Var, @NonNull List<ua4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, xa4Var, list) == null) {
            for (ua4<T> ua4Var : list) {
                xa4Var.c(sa4.b().a(ua4Var));
            }
        }
    }

    @NonNull
    public static xa4 b(mb4 mb4Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mb4Var, n84Var)) == null) {
            List<ua4<mb4.a>> f = wa4.f(mb4Var.a, n84Var);
            xa4 xa4Var = new xa4(n84Var);
            for (ua4<mb4.a> ua4Var : f) {
                xa4Var.c(sa4.b().a(ua4Var));
            }
            return xa4Var;
        }
        return (xa4) invokeLL.objValue;
    }

    public static synchronized void c(nb4 nb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, nb4Var, n84Var) == null) {
            synchronized (fa4.class) {
                ua4<p94> d = wa4.d(nb4Var.d, n84Var);
                ua4<r94> g = wa4.g(nb4Var.a, n84Var);
                ua4<n94> c = wa4.c(nb4Var.f, n84Var);
                List<ua4<s94>> h = wa4.h(nb4Var.b, n84Var);
                List<ua4<t94>> e = wa4.e(nb4Var.c, n84Var);
                xa4 xa4Var = new xa4(n84Var);
                xa4Var.c(sa4.b().a(d));
                xa4Var.c(sa4.b().a(g));
                xa4Var.c(sa4.b().a(c));
                a(xa4Var, h);
                a(xa4Var, e);
                xa4Var.e();
            }
        }
    }

    public static synchronized void d(ob4 ob4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ob4Var, n84Var) == null) {
            synchronized (fa4.class) {
                ua4<t94> i = wa4.i(ob4Var.a, n84Var);
                xa4 xa4Var = new xa4(n84Var);
                xa4Var.c(sa4.b().a(i));
                xa4Var.e();
            }
        }
    }

    public static synchronized void e(pb4 pb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pb4Var, n84Var) == null) {
            synchronized (fa4.class) {
                List<ua4<s94>> h = wa4.h(pb4Var.a, n84Var);
                xa4 xa4Var = new xa4(n84Var);
                for (ua4<s94> ua4Var : h) {
                    xa4Var.c(sa4.b().a(ua4Var));
                }
                xa4Var.e();
            }
        }
    }

    public static synchronized void f(kd4 kd4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, kd4Var, n84Var) == null) {
            synchronized (fa4.class) {
                ua4<p94> d = wa4.d(kd4Var.b, n84Var);
                ua4<p94> d2 = wa4.d(kd4Var.a, n84Var);
                ua4<n94> c = wa4.c(kd4Var.c, n84Var);
                xa4 xa4Var = new xa4(n84Var);
                if (d != null) {
                    xa4Var.c(sa4.b().a(d));
                }
                if (d2 != null) {
                    xa4Var.c(sa4.b().a(d2));
                }
                if (c != null) {
                    xa4Var.c(sa4.b().a(c));
                }
                if (kd4Var.d != null) {
                    for (u94 u94Var : kd4Var.d) {
                        ua4<u94> j = wa4.j(u94Var, n84Var);
                        if (j != null) {
                            xa4Var.c(sa4.b().a(j));
                        }
                    }
                }
                if (kd4Var.e != null) {
                    for (t94 t94Var : kd4Var.e) {
                        ua4<t94> i = wa4.i(t94Var, n84Var);
                        if (i != null) {
                            xa4Var.c(sa4.b().a(i));
                        }
                    }
                }
                xa4Var.e();
            }
        }
    }

    public static synchronized void g(List<t94> list, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, n84Var) == null) {
            synchronized (fa4.class) {
                List<ua4<t94>> e = wa4.e(list, n84Var);
                xa4 xa4Var = new xa4(n84Var);
                a(xa4Var, e);
                xa4Var.e();
            }
        }
    }
}
