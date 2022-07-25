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
public class vw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755216863, "Lcom/repackage/vw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755216863, "Lcom/repackage/vw1;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    @Nullable
    public static <C extends xv1> C a(yv1 yv1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yv1Var)) == null) {
            if (yv1Var == null) {
                bx1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = yv1Var.d();
            String str = yv1Var.c;
            if (TextUtils.isEmpty(str)) {
                ix1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            yw1 d2 = d(str);
            if (d2 == null) {
                ix1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = yv1Var.b;
            if (TextUtils.isEmpty(str2)) {
                ix1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<xv1> list = d2.a().c.get(yv1Var.a);
                if (list == null) {
                    ix1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    ix1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    ix1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                ix1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends xv1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            yw1 d = d(str);
            if (d == null) {
                ix1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                ix1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static yw1 c(yv1 yv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yv1Var)) == null) {
            if (yv1Var == null) {
                bx1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(yv1Var.c);
        }
        return (yw1) invokeL.objValue;
    }

    @Nullable
    public static yw1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                ix1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            qm1 A = vl2.U().A(str);
            if (A instanceof om1) {
                return ((om1) A).e0();
            }
            return null;
        }
        return (yw1) invokeL.objValue;
    }
}
