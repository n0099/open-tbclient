package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(cls, "ro.build.hw_emui_api_level");
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                    return 0;
                }
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? g() ? f("ro.build.version.emui", "") : "" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f(RomUtils.PROP_RO_BUILD_DISPLAY_ID, "") : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? j() ? f(RomUtils.PROP_RO_BUILD_DISPLAY_ID, "") : "" : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? l() ? f("ro.miui.ui.version.name", "") : "" : (String) invokeV.objValue;
    }

    public static String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class, String.class).invoke(cls, str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a() > 0 : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b().contains("EmotionUI_3.0") : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String b = b();
            return "EmotionUI 3".equals(b) || b.contains("EmotionUI_3.1");
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c().toLowerCase().contains("flyme") : invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String d = d();
            if (d.isEmpty()) {
                return false;
            }
            try {
                if (d.toLowerCase().contains("os")) {
                    intValue = Integer.valueOf(d.substring(9, 10)).intValue();
                } else {
                    intValue = Integer.valueOf(d.substring(6, 7)).intValue();
                }
                return intValue >= 4;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? !TextUtils.isEmpty(f("ro.miui.ui.version.name", "")) : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String e = e();
            if (e.isEmpty()) {
                return false;
            }
            try {
                return Integer.valueOf(e.substring(1)).intValue() >= 6;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? "OPPO".equals(Build.MANUFACTURER) : invokeV.booleanValue;
    }
}
