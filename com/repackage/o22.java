package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class o22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755491678, "Lcom/repackage/o22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755491678, "Lcom/repackage/o22;");
                return;
            }
        }
        a = rg1.a;
    }

    public static boolean a(fz1 fz1Var, String str) {
        InterceptResult invokeLL;
        h03 b0;
        j22 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fz1Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (gw2.D()) {
                return false;
            }
            if (fz1Var != null && !TextUtils.isEmpty(fz1Var.getContainerId())) {
                if (w22.i().k(fz1Var.getContainerId())) {
                    return true;
                }
                if (!h42.h()) {
                    return false;
                }
                String containerId = fz1Var.getContainerId();
                if (!n22.a(containerId) || (b0 = h03.b0()) == null || !b(fz1Var) || (a2 = q22.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().b(), fz1Var.getContainerId()) && TextUtils.equals(h, b0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(fz1 fz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fz1Var)) == null) ? (fz1Var instanceof p72) && ((p72) fz1Var).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
