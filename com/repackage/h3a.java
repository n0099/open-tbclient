package com.repackage;

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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class h3a {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public static Method b;
    public static Field c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755697797, "Lcom/repackage/h3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755697797, "Lcom/repackage/h3a;");
                return;
            }
        }
        try {
            a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, layoutParams, str, z)) == null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                int i = declaredField.getInt(layoutParams);
                Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
                declaredField2.setAccessible(true);
                int i2 = declaredField2.getInt(layoutParams);
                int i3 = z ? i | i2 : (~i) & i2;
                if (i2 != i3) {
                    declaredField2.setInt(layoutParams, i3);
                    return true;
                }
                return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return false;
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? j(i) < i2 : invokeII.booleanValue;
    }

    public static void c(Window window, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, window, i) == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field field = c;
            if (field != null) {
                try {
                    if (field.getInt(attributes) != i) {
                        c.set(attributes, Integer.valueOf(i));
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void d(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i) == null) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(activity, Integer.valueOf(i));
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return;
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            boolean b2 = b(i, 50);
            if (c != null) {
                f(activity, b2, b2);
                h(activity.getWindow(), i);
                return;
            }
            e(activity, b2);
        }
    }

    public static void e(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, activity, z) == null) {
            f(activity, z, true);
        }
    }

    public static void f(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Method method = b;
            if (method == null) {
                if (z2) {
                    i(activity.getWindow(), z);
                    return;
                }
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

    public static void g(View view2, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, view2, z) == null) {
            int systemUiVisibility = view2.getSystemUiVisibility();
            if (z) {
                i = d | systemUiVisibility;
            } else {
                i = (~d) & systemUiVisibility;
            }
            if (i != systemUiVisibility) {
                view2.setSystemUiVisibility(i);
            }
        }
    }

    public static void h(Window window, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, window, i) == null) {
            try {
                c(window, i);
                if (Build.VERSION.SDK_INT > 22) {
                    g(window.getDecorView(), true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void i(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, window, z) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                g(decorView, z);
                c(window, 0);
            }
        }
    }

    public static int j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? (((((i & 16711680) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7 : invokeI.intValue;
    }
}
