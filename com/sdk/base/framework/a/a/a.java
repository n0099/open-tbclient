package com.sdk.base.framework.a.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68089a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f68090b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922568214, "Lcom/sdk/base/framework/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922568214, "Lcom/sdk/base/framework/a/a/a;");
                return;
            }
        }
        f68090b = Boolean.valueOf(f.f68206b);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, str)) == null) {
            String a2 = com.sdk.base.framework.f.d.a.a();
            if (c.b(a2).booleanValue()) {
                return YYInnerSSOLoginActivity.o + i2 + str + a2;
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i2, str)) == null) {
            if (SDKManager.useCache()) {
                String a2 = a(i2, str);
                if (c.b(a2).booleanValue()) {
                    String b2 = com.sdk.base.framework.f.b.a.b(context, a2);
                    if (c.b(b2).booleanValue()) {
                        String b3 = b(b2);
                        String a3 = com.sdk.base.framework.f.k.a.a(context, a(b2));
                        if (!com.sdk.base.framework.f.k.a.a(a3)) {
                            c.a(f68089a, "can use cache", f68090b);
                            JSONObject jSONObject = new JSONObject(a3);
                            if (i2 == 1) {
                                jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(jSONObject.toString());
                            sb.append("-");
                            sb.append(b3);
                            return sb.toString();
                        }
                        c.a(f68089a, "OutDate cache invalid", f68090b);
                    }
                }
                return null;
            }
            return null;
        }
        return (String) invokeLIL.objValue;
    }

    public static <T> String a(T t, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, str)) == null) {
            return t + "-" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str.split("-")[0] : (String) invokeL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            c.a(f68089a, "cache clear", f68090b);
            com.sdk.base.framework.f.b.a.d(context, YYInnerSSOLoginActivity.o);
        }
    }

    public static void a(Context context, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65543, null, context, i2, str, str2) == null) && SDKManager.useCache() && c.b(str).booleanValue()) {
            String a2 = a(i2, str2);
            if (c.b(a2).booleanValue()) {
                com.sdk.base.framework.f.b.a.b(context, a2, str);
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str.split("-")[1] : (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            c.a(f68089a, "oauth cache clear", f68090b);
            com.sdk.base.framework.f.b.a.d(context, "accessCode1");
        }
    }
}
