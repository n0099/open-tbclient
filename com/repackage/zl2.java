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
public class zl2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<yl2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755108239, "Lcom/repackage/zl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755108239, "Lcom/repackage/zl2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, rm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yl2 yl2Var = a.get(size).get();
                if (yl2Var == null) {
                    a.remove(size);
                } else {
                    yl2Var.d(rm1Var);
                }
            }
        }
    }

    public static void b(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, rm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yl2 yl2Var = a.get(size).get();
                if (yl2Var == null) {
                    a.remove(size);
                } else {
                    yl2Var.b(rm1Var);
                }
            }
        }
    }

    public static void c(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yl2 yl2Var = a.get(size).get();
                if (yl2Var == null) {
                    a.remove(size);
                } else {
                    yl2Var.c(rm1Var);
                }
            }
        }
    }

    public static void d(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rm1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                yl2 yl2Var = a.get(size).get();
                if (yl2Var == null) {
                    a.remove(size);
                } else {
                    yl2Var.a(rm1Var);
                }
            }
        }
    }

    public static void e(yl2 yl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, yl2Var) == null) || yl2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            yl2 yl2Var2 = a.get(size).get();
            if (yl2Var2 == null) {
                a.remove(size);
            } else {
                z = yl2Var2 == yl2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(yl2Var));
    }

    public static void f(yl2 yl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, yl2Var) == null) || yl2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            yl2 yl2Var2 = a.get(size).get();
            if (yl2Var2 == null || yl2Var == yl2Var2) {
                a.remove(size);
            }
        }
    }
}
