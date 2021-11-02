package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class am {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f66628a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(408734390, "Lcom/kwad/sdk/utils/am;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(408734390, "Lcom/kwad/sdk/utils/am;");
        }
    }

    public static long a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static String a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "") : (String) invokeL.objValue;
    }

    public static void a(@NonNull Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, str, i2) == null) {
            context.getSharedPreferences("ksadsdk_data_flow_auto_start", 0).edit().putInt(str, i2).apply();
        }
    }

    public static void a(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2) == null) {
            context.getSharedPreferences("ksadsdk_download_package_md5", 0).edit().putString(str, str2).apply();
        }
    }

    public static long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_download_package_length", 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static String b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context.getSharedPreferences("ksadsdk_model", 0).getString("KEY_SDK_MODEL", "") : (String) invokeL.objValue;
    }

    public static void b(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
        }
    }

    public static String c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "") : (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? !TextUtils.isEmpty(f66628a) ? f66628a : context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "") : (String) invokeL.objValue;
    }

    public static void d(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
        }
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("oaid", "") : (String) invokeL.objValue;
    }

    public static void e(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            context.getSharedPreferences("ksadsdk_model", 0).edit().putString("KEY_SDK_MODEL", str).apply();
        }
    }

    public static int f(@NonNull Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) ? context.getSharedPreferences("ksadsdk_data_flow_auto_start", 0).getInt(str, -1) : invokeLL.intValue;
    }

    public static void g(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
        }
    }

    public static void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            f66628a = str;
            if (context == null) {
                return;
            }
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
        }
    }

    public static void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) || context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("oaid", str).apply();
    }
}
