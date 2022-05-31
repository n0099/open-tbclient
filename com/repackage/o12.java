package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class o12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755492639, "Lcom/repackage/o12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755492639, "Lcom/repackage/o12;");
                return;
            }
        }
        a = rf1.a;
    }

    public static boolean a(fy1 fy1Var, String str) {
        InterceptResult invokeLL;
        hz2 a0;
        j12 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fy1Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (gv2.D()) {
                return false;
            }
            if (fy1Var != null && !TextUtils.isEmpty(fy1Var.getContainerId())) {
                if (w12.i().k(fy1Var.getContainerId())) {
                    return true;
                }
                if (!h32.h()) {
                    return false;
                }
                String containerId = fy1Var.getContainerId();
                if (!n12.a(containerId) || (a0 = hz2.a0()) == null || !b(fy1Var) || (a2 = q12.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().c(), fy1Var.getContainerId()) && TextUtils.equals(h, a0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fy1Var)) == null) ? (fy1Var instanceof p62) && ((p62) fy1Var).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
