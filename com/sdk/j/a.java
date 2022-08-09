package com.sdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.f.g;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.j.a";
    public static final Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593048178, "Lcom/sdk/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593048178, "Lcom/sdk/j/a;");
                return;
            }
        }
        b = Boolean.valueOf(g.b);
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
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

    public static void a(Context context, String str, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, l) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
                edit.putLong(str, l.longValue());
                edit.commit();
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), b);
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
                edit.putString(str, str2);
                return edit.commit();
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), b);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            long j = 0;
            try {
                j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0L);
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), b);
            }
            return Long.valueOf(j);
        }
        return (Long) invokeLL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), b);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
