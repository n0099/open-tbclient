package com.sdk.base.framework.f.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.i.c;
import java.nio.charset.Charset;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f41216a = "com.sdk.base.framework.f.b.a";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f41217b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065743760, "Lcom/sdk/base/framework/f/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065743760, "Lcom/sdk/base/framework/f/b/a;");
                return;
            }
        }
        f41217b = Boolean.valueOf(f.f41195b);
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

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            String str2 = "";
            try {
                str2 = context.getSharedPreferences("ZzxCache", 0).getString(str, "");
                return new String(c.a(str2), Charset.defaultCharset());
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, String str, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, l) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
                edit.putLong(str, l.longValue());
                edit.commit();
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, context, str, str2)) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
                edit.putString(str, c.a(str2.getBytes(Charset.defaultCharset())));
                return edit.commit();
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            try {
                return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2)) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
                edit.putString(str, str2);
                return edit.commit();
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Long c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            long j = 0;
            try {
                j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0L);
            } catch (Exception e2) {
                com.sdk.base.framework.a.a.c.b(f41216a, e2.getMessage(), f41217b);
            }
            return Long.valueOf(j);
        }
        return (Long) invokeLL.objValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ZzxCache", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (String str2 : sharedPreferences.getAll().keySet()) {
                if (str2.startsWith(str)) {
                    edit.remove(str2);
                }
            }
            edit.commit();
        }
    }
}
