package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.bb4;
import java.util.List;
/* loaded from: classes7.dex */
public class u94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ma4 ma4Var, @NonNull List<ja4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ma4Var, list) == null) {
            for (ja4<T> ja4Var : list) {
                ma4Var.c(ha4.b().a(ja4Var));
            }
        }
    }

    @NonNull
    public static ma4 b(bb4 bb4Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bb4Var, c84Var)) == null) {
            List<ja4<bb4.a>> f = la4.f(bb4Var.a, c84Var);
            ma4 ma4Var = new ma4(c84Var);
            for (ja4<bb4.a> ja4Var : f) {
                ma4Var.c(ha4.b().a(ja4Var));
            }
            return ma4Var;
        }
        return (ma4) invokeLL.objValue;
    }

    public static synchronized void c(cb4 cb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cb4Var, c84Var) == null) {
            synchronized (u94.class) {
                ja4<e94> d = la4.d(cb4Var.d, c84Var);
                ja4<g94> g = la4.g(cb4Var.a, c84Var);
                ja4<c94> c = la4.c(cb4Var.f, c84Var);
                List<ja4<h94>> h = la4.h(cb4Var.b, c84Var);
                List<ja4<i94>> e = la4.e(cb4Var.c, c84Var);
                ma4 ma4Var = new ma4(c84Var);
                ma4Var.c(ha4.b().a(d));
                ma4Var.c(ha4.b().a(g));
                ma4Var.c(ha4.b().a(c));
                a(ma4Var, h);
                a(ma4Var, e);
                ma4Var.e();
            }
        }
    }

    public static synchronized void d(db4 db4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, db4Var, c84Var) == null) {
            synchronized (u94.class) {
                ja4<i94> i = la4.i(db4Var.a, c84Var);
                ma4 ma4Var = new ma4(c84Var);
                ma4Var.c(ha4.b().a(i));
                ma4Var.e();
            }
        }
    }

    public static synchronized void e(eb4 eb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eb4Var, c84Var) == null) {
            synchronized (u94.class) {
                List<ja4<h94>> h = la4.h(eb4Var.a, c84Var);
                ma4 ma4Var = new ma4(c84Var);
                for (ja4<h94> ja4Var : h) {
                    ma4Var.c(ha4.b().a(ja4Var));
                }
                ma4Var.e();
            }
        }
    }

    public static synchronized void f(zc4 zc4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, zc4Var, c84Var) == null) {
            synchronized (u94.class) {
                ja4<e94> d = la4.d(zc4Var.b, c84Var);
                ja4<e94> d2 = la4.d(zc4Var.a, c84Var);
                ja4<c94> c = la4.c(zc4Var.c, c84Var);
                ma4 ma4Var = new ma4(c84Var);
                if (d != null) {
                    ma4Var.c(ha4.b().a(d));
                }
                if (d2 != null) {
                    ma4Var.c(ha4.b().a(d2));
                }
                if (c != null) {
                    ma4Var.c(ha4.b().a(c));
                }
                if (zc4Var.d != null) {
                    for (j94 j94Var : zc4Var.d) {
                        ja4<j94> j = la4.j(j94Var, c84Var);
                        if (j != null) {
                            ma4Var.c(ha4.b().a(j));
                        }
                    }
                }
                if (zc4Var.e != null) {
                    for (i94 i94Var : zc4Var.e) {
                        ja4<i94> i = la4.i(i94Var, c84Var);
                        if (i != null) {
                            ma4Var.c(ha4.b().a(i));
                        }
                    }
                }
                ma4Var.e();
            }
        }
    }

    public static synchronized void g(List<i94> list, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, c84Var) == null) {
            synchronized (u94.class) {
                List<ja4<i94>> e = la4.e(list, c84Var);
                ma4 ma4Var = new ma4(c84Var);
                a(ma4Var, e);
                ma4Var.e();
            }
        }
    }
}
