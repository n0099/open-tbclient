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
public class xk2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<wk2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755168782, "Lcom/repackage/xk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755168782, "Lcom/repackage/xk2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(pl1 pl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, pl1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wk2 wk2Var = a.get(size).get();
                if (wk2Var == null) {
                    a.remove(size);
                } else {
                    wk2Var.d(pl1Var);
                }
            }
        }
    }

    public static void b(pl1 pl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pl1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wk2 wk2Var = a.get(size).get();
                if (wk2Var == null) {
                    a.remove(size);
                } else {
                    wk2Var.b(pl1Var);
                }
            }
        }
    }

    public static void c(pl1 pl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pl1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wk2 wk2Var = a.get(size).get();
                if (wk2Var == null) {
                    a.remove(size);
                } else {
                    wk2Var.c(pl1Var);
                }
            }
        }
    }

    public static void d(pl1 pl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pl1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                wk2 wk2Var = a.get(size).get();
                if (wk2Var == null) {
                    a.remove(size);
                } else {
                    wk2Var.a(pl1Var);
                }
            }
        }
    }

    public static void e(wk2 wk2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, wk2Var) == null) || wk2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            wk2 wk2Var2 = a.get(size).get();
            if (wk2Var2 == null) {
                a.remove(size);
            } else {
                z = wk2Var2 == wk2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(wk2Var));
    }

    public static void f(wk2 wk2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, wk2Var) == null) || wk2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            wk2 wk2Var2 = a.get(size).get();
            if (wk2Var2 == null || wk2Var == wk2Var2) {
                a.remove(size);
            }
        }
    }
}
