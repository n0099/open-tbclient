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
public class pm2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<om2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755405188, "Lcom/repackage/pm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755405188, "Lcom/repackage/pm2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(hn1 hn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, hn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                om2 om2Var = a.get(size).get();
                if (om2Var == null) {
                    a.remove(size);
                } else {
                    om2Var.d(hn1Var);
                }
            }
        }
    }

    public static void b(hn1 hn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                om2 om2Var = a.get(size).get();
                if (om2Var == null) {
                    a.remove(size);
                } else {
                    om2Var.b(hn1Var);
                }
            }
        }
    }

    public static void c(hn1 hn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                om2 om2Var = a.get(size).get();
                if (om2Var == null) {
                    a.remove(size);
                } else {
                    om2Var.c(hn1Var);
                }
            }
        }
    }

    public static void d(hn1 hn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hn1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                om2 om2Var = a.get(size).get();
                if (om2Var == null) {
                    a.remove(size);
                } else {
                    om2Var.a(hn1Var);
                }
            }
        }
    }

    public static void e(om2 om2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, om2Var) == null) || om2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            om2 om2Var2 = a.get(size).get();
            if (om2Var2 == null) {
                a.remove(size);
            } else {
                z = om2Var2 == om2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(om2Var));
    }

    public static void f(om2 om2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, om2Var) == null) || om2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            om2 om2Var2 = a.get(size).get();
            if (om2Var2 == null || om2Var == om2Var2) {
                a.remove(size);
            }
        }
    }
}
