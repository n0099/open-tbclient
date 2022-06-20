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
public class il2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<hl2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755614686, "Lcom/repackage/il2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755614686, "Lcom/repackage/il2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(am1 am1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, am1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                hl2 hl2Var = a.get(size).get();
                if (hl2Var == null) {
                    a.remove(size);
                } else {
                    hl2Var.d(am1Var);
                }
            }
        }
    }

    public static void b(am1 am1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, am1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                hl2 hl2Var = a.get(size).get();
                if (hl2Var == null) {
                    a.remove(size);
                } else {
                    hl2Var.b(am1Var);
                }
            }
        }
    }

    public static void c(am1 am1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, am1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                hl2 hl2Var = a.get(size).get();
                if (hl2Var == null) {
                    a.remove(size);
                } else {
                    hl2Var.c(am1Var);
                }
            }
        }
    }

    public static void d(am1 am1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, am1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                hl2 hl2Var = a.get(size).get();
                if (hl2Var == null) {
                    a.remove(size);
                } else {
                    hl2Var.a(am1Var);
                }
            }
        }
    }

    public static void e(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, hl2Var) == null) || hl2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            hl2 hl2Var2 = a.get(size).get();
            if (hl2Var2 == null) {
                a.remove(size);
            } else {
                z = hl2Var2 == hl2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(hl2Var));
    }

    public static void f(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, hl2Var) == null) || hl2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            hl2 hl2Var2 = a.get(size).get();
            if (hl2Var2 == null || hl2Var == hl2Var2) {
                a.remove(size);
            }
        }
    }
}
