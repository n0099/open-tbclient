package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            if (!TextUtils.isEmpty(str2)) {
                return a(str, str2, str3) ? str2 : str4;
            }
            y.f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
            return str4;
        }
        return (String) invokeLLLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !a("eventId", str, 256) : invokeL.booleanValue;
    }

    public static boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, str, str2, i)) == null) {
            if (TextUtils.isEmpty(str2)) {
                sb = new StringBuilder();
                str3 = "checkString() Parameter is empty : ";
            } else if (str2.length() <= i) {
                return true;
            } else {
                sb = new StringBuilder();
                str3 = "checkString() Failure of parameter length check! Parameter:";
            }
            sb.append(str3);
            sb.append(str);
            y.f("hmsSdk", sb.toString());
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2)) {
                sb = new StringBuilder();
                str4 = "checkString() Parameter is null! Parameter:";
            } else if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            } else {
                sb = new StringBuilder();
                str4 = "checkString() Parameter verification failure! Parameter:";
            }
            sb.append(str4);
            sb.append(str);
            y.f("hmsSdk", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Map<String, String> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null || map.size() == 0) {
                str = "onEvent() mapValue has not data.so,The data will be empty";
            } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
                str = "checkMap() the key can't be constants or _constants";
            } else if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            } else {
                str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
            }
            y.f("hmsSdk", str);
            return false;
        }
        return invokeL.booleanValue;
    }
}
