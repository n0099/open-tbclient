package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class up {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(aq aqVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, aqVar, str) == null) {
            zc8 f = dd8.f(aqVar);
            f.c(str);
            f.j(aqVar.h);
            bd8.b().d(f);
        }
    }

    public static void b(aq aqVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, aqVar, i) == null) {
            zc8 f = dd8.f(aqVar);
            f.j(aqVar.h);
            f.l(aqVar.f);
            f.n(i);
            bd8.b().d(f);
        }
    }

    public static void c(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aqVar) == null) {
            bd8.b().d(dd8.p(aqVar));
        }
    }

    public static void d(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aqVar) == null) {
            bd8.b().d(dd8.o(aqVar));
        }
    }

    public static void e(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aqVar) == null) {
            zc8 f = dd8.f(aqVar);
            f.j(aqVar.h);
            bd8.b().d(f);
        }
    }

    public static void f(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aqVar) == null) {
            bd8.b().d(dd8.p(aqVar));
        }
    }

    public static void g(aq aqVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, aqVar, i) == null) {
            zc8 n = dd8.n(aqVar);
            n.i(706);
            boolean z = i == 1000;
            n.c(z ? "APP" : "URL");
            if (!z) {
                n.l(i);
            }
            n.h("DEEPLINK");
            bd8.b().d(n);
        }
    }
}
