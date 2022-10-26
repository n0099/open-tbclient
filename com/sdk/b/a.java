package com.sdk.b;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.g;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public static Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593286506, "Lcom/sdk/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593286506, "Lcom/sdk/b/a;");
                return;
            }
        }
        b = Boolean.valueOf(g.b);
    }

    public static String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            String a2 = com.sdk.l.a.a();
            if (com.sdk.n.a.b(a2).booleanValue()) {
                return YYInnerSSOLoginActivity.o + i + str + a2;
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) {
            return obj + "-" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? str.split("-")[0] : (String) invokeL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            com.sdk.n.a.b(a, "cache clear", b);
            com.sdk.j.a.a(context, YYInnerSSOLoginActivity.o);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? str.split("-")[1] : (String) invokeL.objValue;
    }

    public static String a(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, context, i, str)) == null) {
            if (!SDKManager.useCache) {
                return null;
            }
            String a2 = a(i, str);
            if (com.sdk.n.a.b(a2).booleanValue()) {
                String c = com.sdk.j.a.c(context, a2);
                if (com.sdk.n.a.b(c).booleanValue()) {
                    String b2 = b(c);
                    String a3 = com.sdk.t.a.a(a(c));
                    if (!com.sdk.t.a.b(a3)) {
                        com.sdk.n.a.b(a, "can use cache", b);
                        JSONObject jSONObject = new JSONObject(a3);
                        if (i == 1) {
                            jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(jSONObject.toString());
                        sb.append("-");
                        sb.append(b2);
                        return sb.toString();
                    }
                    com.sdk.n.a.b(a, "OutDate cache invalid", b);
                }
            }
            return null;
        }
        return (String) invokeLIL.objValue;
    }

    public static void a(Context context, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65542, null, context, i, str, str2) == null) && SDKManager.useCache && com.sdk.n.a.b(str).booleanValue()) {
            String a2 = a(i, str2);
            if (com.sdk.n.a.b(a2).booleanValue()) {
                com.sdk.j.a.a(context, a2, str);
            }
        }
    }
}
