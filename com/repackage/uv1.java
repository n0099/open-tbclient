package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class uv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755247615, "Lcom/repackage/uv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755247615, "Lcom/repackage/uv1;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    @Nullable
    public static <C extends wu1> C a(xu1 xu1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xu1Var)) == null) {
            if (xu1Var == null) {
                aw1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = xu1Var.d();
            String str = xu1Var.c;
            if (TextUtils.isEmpty(str)) {
                hw1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            xv1 d2 = d(str);
            if (d2 == null) {
                hw1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = xu1Var.b;
            if (TextUtils.isEmpty(str2)) {
                hw1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<wu1> list = d2.a().c.get(xu1Var.a);
                if (list == null) {
                    hw1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    hw1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    hw1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                hw1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends wu1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            xv1 d = d(str);
            if (d == null) {
                hw1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                hw1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static xv1 c(xu1 xu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xu1Var)) == null) {
            if (xu1Var == null) {
                aw1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(xu1Var.c);
        }
        return (xv1) invokeL.objValue;
    }

    @Nullable
    public static xv1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                hw1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            pl1 A = uk2.U().A(str);
            if (A instanceof nl1) {
                return ((nl1) A).f0();
            }
            return null;
        }
        return (xv1) invokeL.objValue;
    }
}
