package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class q {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f71165a = "kssdk_api_pref";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1711378250, "Lcom/kwad/sdk/api/loader/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1711378250, "Lcom/kwad/sdk/api/loader/q;");
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? b(context, str, "") : (String) invokeLL.objValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            context.getSharedPreferences(f71165a, 0).edit().putLong(str, j2).commit();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            context.getSharedPreferences(f71165a, 0).edit().putString(str, str2).commit();
        }
    }

    public static long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? b(context, str, 0L) : invokeLL.longValue;
    }

    public static long b(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, Long.valueOf(j2)})) == null) ? context.getSharedPreferences(f71165a, 0).getLong(str, j2) : invokeCommon.longValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2)) == null) ? context.getSharedPreferences(f71165a, 0).getString(str, str2) : (String) invokeLLL.objValue;
    }
}
