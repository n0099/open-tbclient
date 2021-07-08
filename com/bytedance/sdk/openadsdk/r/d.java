package com.bytedance.sdk.openadsdk.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.s;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            a("any_door_id", str);
        }
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return b("last_load_splash_ad_time" + str, 0L);
        }
        return invokeL.longValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            a("save_dpl_success_ad_tag", str);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            a("save_dpl_success_materialmeta", str);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            a("save_playable_screen_shot_materialmeta", str);
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? b("is_landing_page_open_market", false) : invokeV.booleanValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? b("sdk_first_init_timestamp", 0L) : invokeV.longValue;
    }

    public static long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? b("sdk_first_init_timestamp", 0L) : invokeV.longValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? b("sdk_brand_video_cahce", "") : (String) invokeV.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b("any_door_id", (String) null) : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? b("save_dpl_success_ad_tag", "") : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? b("save_dpl_success_materialmeta", "") : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? b("save_playable_screen_shot_materialmeta", "") : (String) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            a("sdk_brand_video_cahce", str);
        }
    }

    public static void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65539, null, j, str) == null) {
            a("last_load_splash_ad_time" + str, j);
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b("save_dpl_success_time", 0L) : invokeV.longValue;
    }

    public static void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65553, null, j) == null) {
            a("sdk_first_init_timestamp", j);
        }
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            a("sdk_first_init_timestamp", j);
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            a("splash_storage_from", i2);
        }
    }

    public static boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, str, z)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.a(str, z);
                }
                return s.a("", com.bytedance.sdk.openadsdk.core.o.a()).b(str, z);
            } catch (Throwable unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            a("save_dpl_success_time", j);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            a("is_landing_page_open_market", z);
        }
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Integer.valueOf(i2));
            } else {
                s.a("", com.bytedance.sdk.openadsdk.core.o.a()).a(str, i2);
            }
        } catch (Throwable unused) {
        }
    }

    public static long b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, str, j)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.a(str, j);
                }
                return s.a("", com.bytedance.sdk.openadsdk.core.o.a()).b(str, j);
            } catch (Throwable unused) {
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.b(str, str2);
                }
                return s.a("", com.bytedance.sdk.openadsdk.core.o.a()).b(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Boolean.valueOf(z));
            } else {
                s.a("", com.bytedance.sdk.openadsdk.core.o.a()).a(str, z);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, str, j) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Long.valueOf(j));
            } else {
                s.a("", com.bytedance.sdk.openadsdk.core.o.a()).a(str, j);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(str, str2);
            } else {
                s.a("", com.bytedance.sdk.openadsdk.core.o.a()).a(str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
