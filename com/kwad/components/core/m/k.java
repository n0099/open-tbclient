package com.kwad.components.core.m;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.q;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static Method Jb;
    public static Method Jc;
    public static Field Jd;
    public static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273841263, "Lcom/kwad/components/core/m/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273841263, "Lcom/kwad/components/core/m/k;");
                return;
            }
        }
        try {
            Jb = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Jc = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            Jd = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) q.c((Class<?>) View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Method method = Jc;
            if (method == null) {
                a(activity.getWindow(), z);
                return;
            }
            try {
                method.invoke(activity, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, window, z) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                e(decorView, z);
                setStatusBarColor(window, 0);
            }
        }
    }

    public static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, layoutParams, str, z)) == null) {
            try {
                int intValue = ((Integer) q.c(layoutParams, str)).intValue();
                int intValue2 = ((Integer) q.c(layoutParams, "meizuFlags")).intValue();
                int i = z ? intValue | intValue2 : (~intValue) & intValue2;
                if (intValue2 != i) {
                    q.a(layoutParams, "meizuFlags", Integer.valueOf(i));
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z) == null) {
            a(activity, true, true);
        }
    }

    public static void e(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, view2, z) == null) {
            int systemUiVisibility = view2.getSystemUiVisibility();
            int i = z ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
            if (i != systemUiVisibility) {
                view2.setSystemUiVisibility(i);
            }
        }
    }

    public static void setStatusBarColor(Window window, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, window, i) == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field field = Jd;
            if (field != null) {
                try {
                    if (field.getInt(attributes) != 0) {
                        Jd.set(attributes, 0);
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
