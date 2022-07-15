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
public class uw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755246654, "Lcom/repackage/uw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755246654, "Lcom/repackage/uw1;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    @Nullable
    public static <C extends wv1> C a(xv1 xv1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xv1Var)) == null) {
            if (xv1Var == null) {
                ax1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = xv1Var.d();
            String str = xv1Var.c;
            if (TextUtils.isEmpty(str)) {
                hx1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            xw1 d2 = d(str);
            if (d2 == null) {
                hx1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = xv1Var.b;
            if (TextUtils.isEmpty(str2)) {
                hx1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<wv1> list = d2.a().c.get(xv1Var.a);
                if (list == null) {
                    hx1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    hx1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    hx1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                hx1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends wv1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            xw1 d = d(str);
            if (d == null) {
                hx1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                hx1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static xw1 c(xv1 xv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xv1Var)) == null) {
            if (xv1Var == null) {
                ax1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(xv1Var.c);
        }
        return (xw1) invokeL.objValue;
    }

    @Nullable
    public static xw1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                hx1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            pm1 A = ul2.U().A(str);
            if (A instanceof nm1) {
                return ((nm1) A).e0();
            }
            return null;
        }
        return (xw1) invokeL.objValue;
    }
}
