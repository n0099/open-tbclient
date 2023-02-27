package com.huawei.hms.base.ui;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(95455622, "Lcom/huawei/hms/base/ui/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(95455622, "Lcom/huawei/hms/base/ui/a;");
                return;
            }
        }
        a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int length = str.length();
            int i = 1;
            if (1 == length) {
                return String.valueOf('*');
            }
            StringBuilder sb = new StringBuilder(length);
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (a.matcher(String.valueOf(charAt)).matches()) {
                    if (i % 2 == 0) {
                        charAt = '*';
                    }
                    i++;
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            StringBuilder sb = new StringBuilder(512);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    sb.append(a(str));
                } else {
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, false));
    }

    public static void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, z) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, z));
    }
}
