package com.repackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f01 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755761750, "Lcom/repackage/f01;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755761750, "Lcom/repackage/f01;");
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ("permission_location".equalsIgnoreCase(str)) {
                return b;
            }
            if ("permission_storage".equalsIgnoreCase(str)) {
                return c;
            }
            if ("permission_app_list".equalsIgnoreCase(str)) {
                return d;
            }
            if ("permission_read_phone_state".equalsIgnoreCase(str)) {
                return a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
