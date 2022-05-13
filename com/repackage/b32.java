package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755878000, "Lcom/repackage/b32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755878000, "Lcom/repackage/b32;");
                return;
            }
        }
        a = eh1.a;
    }

    public static boolean a(sz1 sz1Var, String str) {
        InterceptResult invokeLL;
        u03 a0;
        w22 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sz1Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (tw2.D()) {
                return false;
            }
            if (sz1Var != null && !TextUtils.isEmpty(sz1Var.getContainerId())) {
                if (j32.i().k(sz1Var.getContainerId())) {
                    return true;
                }
                if (!u42.h()) {
                    return false;
                }
                String containerId = sz1Var.getContainerId();
                if (!a32.a(containerId) || (a0 = u03.a0()) == null || !b(sz1Var) || (a2 = d32.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().c(), sz1Var.getContainerId()) && TextUtils.equals(h, a0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(sz1 sz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sz1Var)) == null) ? (sz1Var instanceof c82) && ((c82) sz1Var).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
