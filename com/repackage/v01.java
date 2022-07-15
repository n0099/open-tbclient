package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class v01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (f(activity)) {
                return c(activity);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.BRAND;
            return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) ? "navigationbar_is_min" : str.equalsIgnoreCase("XIAOMI") ? "force_fsg_nav_bar" : (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) ? "navigation_gesture_on" : "navigationbar_is_min";
        }
        return (String) invokeV.objValue;
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @RequiresApi(api = 17)
    public static int d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (g(context)) {
                return 0;
            }
            return a((Activity) context);
        }
        return invokeL.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String j = hh0.c().a().j();
            if (TextUtils.isEmpty(j)) {
                return false;
            }
            return j.contains("MI 8") || j.contains("MI 9");
        }
        return invokeV.booleanValue;
    }

    public static boolean f(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            View findViewById = activity.findViewById(16908336);
            return findViewById != null && findViewById.getVisibility() == 0;
        }
        return invokeL.booleanValue;
    }

    @RequiresApi(api = 17)
    public static boolean g(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? Settings.Global.getInt(context.getContentResolver(), b(), 0) != 0 : invokeL.booleanValue;
    }
}
