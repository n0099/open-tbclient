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
public class xl2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<wl2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755167821, "Lcom/repackage/xl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755167821, "Lcom/repackage/xl2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, pm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wl2 wl2Var = a.get(size).get();
                if (wl2Var == null) {
                    a.remove(size);
                } else {
                    wl2Var.d(pm1Var);
                }
            }
        }
    }

    public static void b(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wl2 wl2Var = a.get(size).get();
                if (wl2Var == null) {
                    a.remove(size);
                } else {
                    wl2Var.b(pm1Var);
                }
            }
        }
    }

    public static void c(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wl2 wl2Var = a.get(size).get();
                if (wl2Var == null) {
                    a.remove(size);
                } else {
                    wl2Var.c(pm1Var);
                }
            }
        }
    }

    public static void d(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wl2 wl2Var = a.get(size).get();
                if (wl2Var == null) {
                    a.remove(size);
                } else {
                    wl2Var.a(pm1Var);
                }
            }
        }
    }

    public static void e(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, wl2Var) == null) || wl2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            wl2 wl2Var2 = a.get(size).get();
            if (wl2Var2 == null) {
                a.remove(size);
            } else {
                z = wl2Var2 == wl2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(wl2Var));
    }

    public static void f(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, wl2Var) == null) || wl2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            wl2 wl2Var2 = a.get(size).get();
            if (wl2Var2 == null || wl2Var == wl2Var2) {
                a.remove(size);
            }
        }
    }
}
