package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dj2;
import com.repackage.el2;
import java.io.File;
/* loaded from: classes7.dex */
public class r62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398461, "Lcom/repackage/r62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398461, "Lcom/repackage/r62;");
                return;
            }
        }
        a = rg1.a;
        oj2.g0().getSwitch("swan_naview_slave_preload_type", 0);
        c = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!b72.U().r0()) {
                Log.w("NASlaveConfig", "v8 is not enabled");
                return false;
            } else if (oj2.F0().j(1)) {
                String c0 = b72.U().c0();
                if (TextUtils.isEmpty(c0)) {
                    Log.w("NASlaveConfig", "base path is not exists");
                    return false;
                } else if (!new File(c0, "slave-talos/index.js").isFile()) {
                    Log.w("NASlaveConfig", "talos-js file is not exists");
                    return false;
                } else if (a && gw2.Y()) {
                    return true;
                } else {
                    boolean z = c != 0;
                    if (a) {
                        Log.d("NASlaveConfig", "isNARenderEnabled canUseNA: " + z);
                    }
                    return z;
                }
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int b(@Nullable w03 w03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, w03Var)) == null) {
            if (w03Var == null || !d()) {
                return 0;
            }
            return "na".equals(w03Var.r) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            int b2 = b(ul2.U().f(str));
            if (a) {
                Log.d("NASlaveConfig", "getSlaveType pageUrl: " + str + " slaveType:" + b2);
            }
            return b2;
        }
        return invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Boolean bool = b;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(a());
            b = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c == 1 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c == 3 : invokeV.booleanValue;
    }

    public static boolean h(h03 h03Var) {
        InterceptResult invokeL;
        el2.a W;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, h03Var)) == null) {
            if (h03Var == null || !h03Var.E()) {
                return false;
            }
            if (gw2.B(h03Var.W())) {
                str = dj2.b.g().getPath() + File.separator;
            } else {
                str = dj2.e.i(W.H(), W.v1()).getPath() + File.separator;
            }
            if (a) {
                Log.d("NASlaveConfig", "手动解析的basePath: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            ul2.U().K(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
