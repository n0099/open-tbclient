package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.cb4;
import java.util.List;
/* loaded from: classes7.dex */
public class v94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull na4 na4Var, @NonNull List<ka4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, na4Var, list) == null) {
            for (ka4<T> ka4Var : list) {
                na4Var.c(ia4.b().a(ka4Var));
            }
        }
    }

    @NonNull
    public static na4 b(cb4 cb4Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cb4Var, d84Var)) == null) {
            List<ka4<cb4.a>> f = ma4.f(cb4Var.a, d84Var);
            na4 na4Var = new na4(d84Var);
            for (ka4<cb4.a> ka4Var : f) {
                na4Var.c(ia4.b().a(ka4Var));
            }
            return na4Var;
        }
        return (na4) invokeLL.objValue;
    }

    public static synchronized void c(db4 db4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, db4Var, d84Var) == null) {
            synchronized (v94.class) {
                ka4<f94> d = ma4.d(db4Var.d, d84Var);
                ka4<h94> g = ma4.g(db4Var.a, d84Var);
                ka4<d94> c = ma4.c(db4Var.f, d84Var);
                List<ka4<i94>> h = ma4.h(db4Var.b, d84Var);
                List<ka4<j94>> e = ma4.e(db4Var.c, d84Var);
                na4 na4Var = new na4(d84Var);
                na4Var.c(ia4.b().a(d));
                na4Var.c(ia4.b().a(g));
                na4Var.c(ia4.b().a(c));
                a(na4Var, h);
                a(na4Var, e);
                na4Var.e();
            }
        }
    }

    public static synchronized void d(eb4 eb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, eb4Var, d84Var) == null) {
            synchronized (v94.class) {
                ka4<j94> i = ma4.i(eb4Var.a, d84Var);
                na4 na4Var = new na4(d84Var);
                na4Var.c(ia4.b().a(i));
                na4Var.e();
            }
        }
    }

    public static synchronized void e(fb4 fb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fb4Var, d84Var) == null) {
            synchronized (v94.class) {
                List<ka4<i94>> h = ma4.h(fb4Var.a, d84Var);
                na4 na4Var = new na4(d84Var);
                for (ka4<i94> ka4Var : h) {
                    na4Var.c(ia4.b().a(ka4Var));
                }
                na4Var.e();
            }
        }
    }

    public static synchronized void f(ad4 ad4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ad4Var, d84Var) == null) {
            synchronized (v94.class) {
                ka4<f94> d = ma4.d(ad4Var.b, d84Var);
                ka4<f94> d2 = ma4.d(ad4Var.a, d84Var);
                ka4<d94> c = ma4.c(ad4Var.c, d84Var);
                na4 na4Var = new na4(d84Var);
                if (d != null) {
                    na4Var.c(ia4.b().a(d));
                }
                if (d2 != null) {
                    na4Var.c(ia4.b().a(d2));
                }
                if (c != null) {
                    na4Var.c(ia4.b().a(c));
                }
                if (ad4Var.d != null) {
                    for (k94 k94Var : ad4Var.d) {
                        ka4<k94> j = ma4.j(k94Var, d84Var);
                        if (j != null) {
                            na4Var.c(ia4.b().a(j));
                        }
                    }
                }
                if (ad4Var.e != null) {
                    for (j94 j94Var : ad4Var.e) {
                        ka4<j94> i = ma4.i(j94Var, d84Var);
                        if (i != null) {
                            na4Var.c(ia4.b().a(i));
                        }
                    }
                }
                na4Var.e();
            }
        }
    }

    public static synchronized void g(List<j94> list, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, d84Var) == null) {
            synchronized (v94.class) {
                List<ka4<j94>> e = ma4.e(list, d84Var);
                na4 na4Var = new na4(d84Var);
                a(na4Var, e);
                na4Var.e();
            }
        }
    }
}
