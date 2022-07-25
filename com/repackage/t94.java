package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ab4;
import java.util.List;
/* loaded from: classes7.dex */
public class t94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull la4 la4Var, @NonNull List<ia4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, la4Var, list) == null) {
            for (ia4<T> ia4Var : list) {
                la4Var.c(ga4.b().a(ia4Var));
            }
        }
    }

    @NonNull
    public static la4 b(ab4 ab4Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ab4Var, b84Var)) == null) {
            List<ia4<ab4.a>> f = ka4.f(ab4Var.a, b84Var);
            la4 la4Var = new la4(b84Var);
            for (ia4<ab4.a> ia4Var : f) {
                la4Var.c(ga4.b().a(ia4Var));
            }
            return la4Var;
        }
        return (la4) invokeLL.objValue;
    }

    public static synchronized void c(bb4 bb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bb4Var, b84Var) == null) {
            synchronized (t94.class) {
                ia4<d94> d = ka4.d(bb4Var.d, b84Var);
                ia4<f94> g = ka4.g(bb4Var.a, b84Var);
                ia4<b94> c = ka4.c(bb4Var.f, b84Var);
                List<ia4<g94>> h = ka4.h(bb4Var.b, b84Var);
                List<ia4<h94>> e = ka4.e(bb4Var.c, b84Var);
                la4 la4Var = new la4(b84Var);
                la4Var.c(ga4.b().a(d));
                la4Var.c(ga4.b().a(g));
                la4Var.c(ga4.b().a(c));
                a(la4Var, h);
                a(la4Var, e);
                la4Var.e();
            }
        }
    }

    public static synchronized void d(cb4 cb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cb4Var, b84Var) == null) {
            synchronized (t94.class) {
                ia4<h94> i = ka4.i(cb4Var.a, b84Var);
                la4 la4Var = new la4(b84Var);
                la4Var.c(ga4.b().a(i));
                la4Var.e();
            }
        }
    }

    public static synchronized void e(db4 db4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, db4Var, b84Var) == null) {
            synchronized (t94.class) {
                List<ia4<g94>> h = ka4.h(db4Var.a, b84Var);
                la4 la4Var = new la4(b84Var);
                for (ia4<g94> ia4Var : h) {
                    la4Var.c(ga4.b().a(ia4Var));
                }
                la4Var.e();
            }
        }
    }

    public static synchronized void f(yc4 yc4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, yc4Var, b84Var) == null) {
            synchronized (t94.class) {
                ia4<d94> d = ka4.d(yc4Var.b, b84Var);
                ia4<d94> d2 = ka4.d(yc4Var.a, b84Var);
                ia4<b94> c = ka4.c(yc4Var.c, b84Var);
                la4 la4Var = new la4(b84Var);
                if (d != null) {
                    la4Var.c(ga4.b().a(d));
                }
                if (d2 != null) {
                    la4Var.c(ga4.b().a(d2));
                }
                if (c != null) {
                    la4Var.c(ga4.b().a(c));
                }
                if (yc4Var.d != null) {
                    for (i94 i94Var : yc4Var.d) {
                        ia4<i94> j = ka4.j(i94Var, b84Var);
                        if (j != null) {
                            la4Var.c(ga4.b().a(j));
                        }
                    }
                }
                if (yc4Var.e != null) {
                    for (h94 h94Var : yc4Var.e) {
                        ia4<h94> i = ka4.i(h94Var, b84Var);
                        if (i != null) {
                            la4Var.c(ga4.b().a(i));
                        }
                    }
                }
                la4Var.e();
            }
        }
    }

    public static synchronized void g(List<h94> list, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, b84Var) == null) {
            synchronized (t94.class) {
                List<ia4<h94>> e = ka4.e(list, b84Var);
                la4 la4Var = new la4(b84Var);
                a(la4Var, e);
                la4Var.e();
            }
        }
    }
}
