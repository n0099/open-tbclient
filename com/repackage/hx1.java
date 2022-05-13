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
/* loaded from: classes6.dex */
public class hx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755632976, "Lcom/repackage/hx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755632976, "Lcom/repackage/hx1;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    @Nullable
    public static <C extends jw1> C a(kw1 kw1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kw1Var)) == null) {
            if (kw1Var == null) {
                nx1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = kw1Var.d();
            String str = kw1Var.c;
            if (TextUtils.isEmpty(str)) {
                ux1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            kx1 d2 = d(str);
            if (d2 == null) {
                ux1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = kw1Var.b;
            if (TextUtils.isEmpty(str2)) {
                ux1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<jw1> list = d2.a().c.get(kw1Var.a);
                if (list == null) {
                    ux1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    ux1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    ux1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                ux1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends jw1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            kx1 d = d(str);
            if (d == null) {
                ux1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                ux1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static kx1 c(kw1 kw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, kw1Var)) == null) {
            if (kw1Var == null) {
                nx1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(kw1Var.c);
        }
        return (kx1) invokeL.objValue;
    }

    @Nullable
    public static kx1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                ux1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            cn1 A = hm2.U().A(str);
            if (A instanceof an1) {
                return ((an1) A).f0();
            }
            return null;
        }
        return (kx1) invokeL.objValue;
    }
}
