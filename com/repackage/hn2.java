package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class hn2 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<gn2> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755642555, "Lcom/repackage/hn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755642555, "Lcom/repackage/hn2;");
                return;
            }
        }
        a = new ArrayList<>();
    }

    public static void a(gn2 gn2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, gn2Var) == null) || gn2Var == null || a.contains(gn2Var)) {
            return;
        }
        a.add(gn2Var);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.clear();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null) {
                    gn2Var.onDestroy();
                }
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            gn2 gn2Var = a.get(size);
            if (gn2Var != null && TextUtils.equals(str, gn2Var.b())) {
                gn2Var.onDestroy();
            }
        }
    }

    public static gn2 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null && TextUtils.equals(str, gn2Var.c())) {
                    return gn2Var;
                }
            }
            return null;
        }
        return (gn2) invokeL.objValue;
    }

    public static gn2 f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, gn2Var.b())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, gn2Var.f())) || TextUtils.equals(str3, gn2Var.c())))) {
                    return gn2Var;
                }
            }
            return null;
        }
        return (gn2) invokeLLL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null && TextUtils.equals(str, gn2Var.b()) && gn2Var.onBackPressed()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null) {
                    gn2Var.j(z);
                }
            }
        }
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65545, null, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            gn2 gn2Var = a.get(size);
            if (gn2Var != null && TextUtils.equals(str, gn2Var.b())) {
                gn2Var.k(z);
            }
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                gn2 gn2Var = a.get(size);
                if (gn2Var != null) {
                    gn2Var.k(z);
                }
            }
        }
    }

    public static void k(gn2 gn2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, gn2Var) == null) || gn2Var == null) {
            return;
        }
        a.remove(gn2Var);
    }
}
