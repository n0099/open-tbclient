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
/* loaded from: classes7.dex */
public class yl2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<xl2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755138030, "Lcom/repackage/yl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755138030, "Lcom/repackage/yl2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, qm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                xl2 xl2Var = a.get(size).get();
                if (xl2Var == null) {
                    a.remove(size);
                } else {
                    xl2Var.d(qm1Var);
                }
            }
        }
    }

    public static void b(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                xl2 xl2Var = a.get(size).get();
                if (xl2Var == null) {
                    a.remove(size);
                } else {
                    xl2Var.b(qm1Var);
                }
            }
        }
    }

    public static void c(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                xl2 xl2Var = a.get(size).get();
                if (xl2Var == null) {
                    a.remove(size);
                } else {
                    xl2Var.c(qm1Var);
                }
            }
        }
    }

    public static void d(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                xl2 xl2Var = a.get(size).get();
                if (xl2Var == null) {
                    a.remove(size);
                } else {
                    xl2Var.a(qm1Var);
                }
            }
        }
    }

    public static void e(xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, xl2Var) == null) || xl2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            xl2 xl2Var2 = a.get(size).get();
            if (xl2Var2 == null) {
                a.remove(size);
            } else {
                z = xl2Var2 == xl2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(xl2Var));
    }

    public static void f(xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, xl2Var) == null) || xl2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            xl2 xl2Var2 = a.get(size).get();
            if (xl2Var2 == null || xl2Var == xl2Var2) {
                a.remove(size);
            }
        }
    }
}
