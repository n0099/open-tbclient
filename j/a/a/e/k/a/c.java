package j.a.a.e.k.a;

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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64648b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f64649c;

    /* renamed from: d  reason: collision with root package name */
    public static int f64650d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1898788321, "Lj/a/a/e/k/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1898788321, "Lj/a/a/e/k/a/c;");
                return;
            }
        }
        try {
            a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f64648b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f64649c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f64650d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
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

    public static boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? j(i2) < i3 : invokeII.booleanValue;
    }

    public static void c(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, window, i2) == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field field = f64649c;
            if (field != null) {
                try {
                    if (field.getInt(attributes) != i2) {
                        f64649c.set(attributes, Integer.valueOf(i2));
                        window.setAttributes(attributes);
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void d(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i2) == null) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(activity, Integer.valueOf(i2));
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            boolean b2 = b(i2, 50);
            if (f64649c != null) {
                f(activity, b2, b2);
                h(activity.getWindow(), i2);
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
            Method method = f64648b;
            if (method == null) {
                if (z2) {
                    i(activity.getWindow(), z);
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

    public static void g(View view, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, view, z) == null) {
            int systemUiVisibility = view.getSystemUiVisibility();
            if (z) {
                i2 = f64650d | systemUiVisibility;
            } else {
                i2 = (~f64650d) & systemUiVisibility;
            }
            if (i2 != systemUiVisibility) {
                view.setSystemUiVisibility(i2);
            }
        }
    }

    public static void h(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, window, i2) == null) {
            try {
                c(window, i2);
                if (Build.VERSION.SDK_INT > 22) {
                    g(window.getDecorView(), true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
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

    public static int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? (((((i2 & 16711680) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7 : invokeI.intValue;
    }
}
