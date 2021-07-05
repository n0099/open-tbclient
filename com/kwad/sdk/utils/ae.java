package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f39316a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(408734142, "Lcom/kwad/sdk/utils/ae;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(408734142, "Lcom/kwad/sdk/utils/ae;");
        }
    }

    public static int a(@NonNull Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) ? context.getSharedPreferences("ksadsdk_pref", 0).getInt("profile_guide_times", i2) : invokeLI.intValue;
    }

    public static long a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static void a(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, context, str, str2) == null) {
            context.getSharedPreferences("ksadsdk_download_package_md5", 0).edit().putString(str, str2).apply();
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_slide_left", true) : invokeL.booleanValue;
    }

    public static long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_download_package_length", 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_slide_left", false).apply();
        }
    }

    public static void b(@NonNull Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, context, i2) == null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putInt("profile_guide_times", i2).apply();
        }
    }

    public static void b(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
        }
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_slideup", true) : invokeL.booleanValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_slideup", false).apply();
        }
    }

    public static void d(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
        }
    }

    public static String e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "") : (String) invokeL.objValue;
    }

    public static void e(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
        }
    }

    public static String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "") : (String) invokeL.objValue;
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            f39316a = str;
            if (context == null) {
                return;
            }
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
        }
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? !TextUtils.isEmpty(f39316a) ? f39316a : context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "") : (String) invokeL.objValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, context, str) == null) || context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("oaid", str).apply();
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("oaid", "") : (String) invokeL.objValue;
    }
}
