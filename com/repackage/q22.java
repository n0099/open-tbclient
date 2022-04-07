package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755432096, "Lcom/repackage/q22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755432096, "Lcom/repackage/q22;");
                return;
            }
        }
        a = tg1.a;
    }

    public static boolean a(hz1 hz1Var, String str) {
        InterceptResult invokeLL;
        j03 a0;
        l22 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hz1Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (iw2.D()) {
                return false;
            }
            if (hz1Var != null && !TextUtils.isEmpty(hz1Var.getContainerId())) {
                if (y22.i().k(hz1Var.getContainerId())) {
                    return true;
                }
                if (!j42.h()) {
                    return false;
                }
                String containerId = hz1Var.getContainerId();
                if (!p22.a(containerId) || (a0 = j03.a0()) == null || !b(hz1Var) || (a2 = s22.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().c(), hz1Var.getContainerId()) && TextUtils.equals(h, a0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(hz1 hz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hz1Var)) == null) ? (hz1Var instanceof r72) && ((r72) hz1Var).getInvokeSourceType() == 0 : invokeL.booleanValue;
    }
}
