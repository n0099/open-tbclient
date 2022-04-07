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
public class ww1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755187072, "Lcom/repackage/ww1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755187072, "Lcom/repackage/ww1;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    @Nullable
    public static <C extends yv1> C a(zv1 zv1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zv1Var)) == null) {
            if (zv1Var == null) {
                cx1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = zv1Var.d();
            String str = zv1Var.c;
            if (TextUtils.isEmpty(str)) {
                jx1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            zw1 d2 = d(str);
            if (d2 == null) {
                jx1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = zv1Var.b;
            if (TextUtils.isEmpty(str2)) {
                jx1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<yv1> list = d2.a().c.get(zv1Var.a);
                if (list == null) {
                    jx1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    jx1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    jx1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                jx1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends yv1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            zw1 d = d(str);
            if (d == null) {
                jx1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                jx1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static zw1 c(zv1 zv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zv1Var)) == null) {
            if (zv1Var == null) {
                cx1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(zv1Var.c);
        }
        return (zw1) invokeL.objValue;
    }

    @Nullable
    public static zw1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                jx1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            rm1 A = wl2.U().A(str);
            if (A instanceof pm1) {
                return ((pm1) A).f0();
            }
            return null;
        }
        return (zw1) invokeL.objValue;
    }
}
