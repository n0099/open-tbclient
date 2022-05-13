package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class km2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<jm2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755554143, "Lcom/repackage/km2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755554143, "Lcom/repackage/km2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jm2 jm2Var = a.get(size).get();
                if (jm2Var == null) {
                    a.remove(size);
                } else {
                    jm2Var.d(cn1Var);
                }
            }
        }
    }

    public static void b(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jm2 jm2Var = a.get(size).get();
                if (jm2Var == null) {
                    a.remove(size);
                } else {
                    jm2Var.b(cn1Var);
                }
            }
        }
    }

    public static void c(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jm2 jm2Var = a.get(size).get();
                if (jm2Var == null) {
                    a.remove(size);
                } else {
                    jm2Var.c(cn1Var);
                }
            }
        }
    }

    public static void d(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                jm2 jm2Var = a.get(size).get();
                if (jm2Var == null) {
                    a.remove(size);
                } else {
                    jm2Var.a(cn1Var);
                }
            }
        }
    }

    public static void e(jm2 jm2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, jm2Var) == null) || jm2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            jm2 jm2Var2 = a.get(size).get();
            if (jm2Var2 == null) {
                a.remove(size);
            } else {
                z = jm2Var2 == jm2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(jm2Var));
    }

    public static void f(jm2 jm2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, jm2Var) == null) || jm2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            jm2 jm2Var2 = a.get(size).get();
            if (jm2Var2 == null || jm2Var == jm2Var2) {
                a.remove(size);
            }
        }
    }
}
