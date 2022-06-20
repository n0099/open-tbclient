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
public class fw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755693519, "Lcom/repackage/fw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755693519, "Lcom/repackage/fw1;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    @Nullable
    public static <C extends hv1> C a(iv1 iv1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iv1Var)) == null) {
            if (iv1Var == null) {
                lw1.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = iv1Var.d();
            String str = iv1Var.c;
            if (TextUtils.isEmpty(str)) {
                sw1.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            iw1 d2 = d(str);
            if (d2 == null) {
                sw1.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = iv1Var.b;
            if (TextUtils.isEmpty(str2)) {
                sw1.o("Component-Finder", "find " + d + " with a empty componentId");
                List<hv1> list = d2.a().c.get(iv1Var.a);
                if (list == null) {
                    sw1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    sw1.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    sw1.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                sw1.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends hv1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            iw1 d = d(str);
            if (d == null) {
                sw1.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                sw1.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static iw1 c(iv1 iv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iv1Var)) == null) {
            if (iv1Var == null) {
                lw1.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(iv1Var.c);
        }
        return (iw1) invokeL.objValue;
    }

    @Nullable
    public static iw1 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                sw1.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            am1 A = fl2.U().A(str);
            if (A instanceof yl1) {
                return ((yl1) A).f0();
            }
            return null;
        }
        return (iw1) invokeL.objValue;
    }
}
