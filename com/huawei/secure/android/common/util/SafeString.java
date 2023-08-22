package com.huawei.secure.android.common.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SafeString {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SafeString";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(895107850, "Lcom/huawei/secure/android/common/util/SafeString;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(895107850, "Lcom/huawei/secure/android/common/util/SafeString;");
        }
    }

    public SafeString() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, charSequence, charSequence2)) == null) {
            if (str != null && charSequence != null && charSequence2 != null) {
                try {
                    return str.replace(charSequence, charSequence2);
                } catch (Exception e) {
                    String str2 = a;
                    Log.e(str2, "replace: " + e.getMessage());
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String substring(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2)) == null) {
            if (str != null && i >= 0 && i2 <= str.length() && i2 >= i) {
                try {
                    return str.substring(i, i2);
                } catch (Exception e) {
                    String str2 = a;
                    Log.e(str2, "substring: " + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeLII.objValue;
    }

    public static String substring(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (str != null && str.length() >= i && i >= 0) {
                try {
                    return str.substring(i);
                } catch (Exception e) {
                    String str2 = a;
                    Log.e(str2, "substring exception: " + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }
}
