package com.repackage;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class yg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755142773, "Lcom/repackage/yg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755142773, "Lcom/repackage/yg4;");
                return;
            }
        }
        a = Arrays.asList("TAH-AN00", "TET-AN00");
    }

    public static int a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            double b = b(activity) * 0.5199999809265137d;
            if (b < 1148.0d) {
                return 1148;
            }
            return (int) b;
        }
        return invokeL.intValue;
    }

    public static double b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (c(activity)) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            return 0.0d;
        }
        return invokeL.doubleValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) ? (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true : invokeL.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if (TextUtils.equals("HUAWEI", str) && !TextUtils.isEmpty(str2)) {
                for (String str3 : a) {
                    if (str2.contains(str3)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            double d = displayMetrics.widthPixels;
            double d2 = displayMetrics.heightPixels;
            return (d == 0.0d || d2 == 0.0d || d2 / d >= 1.5d) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
