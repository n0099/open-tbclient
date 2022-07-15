package com.repackage;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class tx4 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755275391, "Lcom/repackage/tx4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755275391, "Lcom/repackage/tx4;");
                return;
            }
        }
        a = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (oi.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
                if (b == null && (q = xt4.k().q("js_host_white_list", null)) != null) {
                    b = b(q);
                }
                if (b == null) {
                    b = a;
                }
                if (parse != null) {
                    String host = parse.getHost();
                    for (String str2 : b) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (oi.isEmpty(str)) {
                return null;
            }
            return Arrays.asList(str.split(ParamableElem.DIVIDE_PARAM));
        }
        return (List) invokeL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str == null) {
                xt4.k().y("js_host_white_list", "");
            } else {
                xt4.k().y("js_host_white_list", str);
            }
            b = b(str);
        }
    }
}
