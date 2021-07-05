package com.kwad.sdk.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Method f39412a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f39413b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f39414c;

    /* renamed from: d  reason: collision with root package name */
    public static int f39415d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835105, "Lcom/kwad/sdk/utils/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835105, "Lcom/kwad/sdk/utils/u;");
                return;
            }
        }
        try {
            f39412a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            f39413b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
        try {
            f39414c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        try {
            f39415d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
    }

    public static void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, activity, z) == null) {
            a(activity, z, true);
        }
    }

    public static void a(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Method method = f39413b;
            if (method == null) {
                if (z2) {
                    a(activity.getWindow(), z);
                    return;
                }
                return;
            }
            try {
                method.invoke(activity, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, view, z) == null) {
            int systemUiVisibility = view.getSystemUiVisibility();
            int i2 = z ? f39415d | systemUiVisibility : (~f39415d) & systemUiVisibility;
            if (i2 != systemUiVisibility) {
                view.setSystemUiVisibility(i2);
            }
        }
    }

    public static void a(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65540, null, window, i2) == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field field = f39414c;
            if (field != null) {
                try {
                    if (field.getInt(attributes) != i2) {
                        f39414c.set(attributes, Integer.valueOf(i2));
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, window, z) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                a(decorView, z);
                a(window, 0);
            }
        }
    }

    public static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, layoutParams, str, z)) == null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(layoutParams);
                Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
                declaredField2.setAccessible(true);
                int i3 = declaredField2.getInt(layoutParams);
                int i4 = z ? i2 | i3 : (~i2) & i3;
                if (i3 != i4) {
                    declaredField2.setInt(layoutParams, i4);
                    return true;
                }
                return false;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return false;
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
