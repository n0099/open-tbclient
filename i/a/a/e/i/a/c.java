package i.a.a.e.i.a;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Method f72060a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f72061b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f72062c;

    /* renamed from: d  reason: collision with root package name */
    public static int f72063d;

    static {
        try {
            f72060a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f72061b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f72062c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f72063d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
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

    public static boolean b(int i2, int i3) {
        return j(i2) < i3;
    }

    public static void c(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f72062c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    f72062c.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(Activity activity, int i2) {
        Method method = f72060a;
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
        if (f72062c != null) {
            f(activity, b2, b2);
            h(activity.getWindow(), i2);
            return;
        }
        e(activity, b2);
    }

    public static void e(Activity activity, boolean z) {
        f(activity, z, true);
    }

    public static void f(Activity activity, boolean z, boolean z2) {
        Method method = f72061b;
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

    public static void g(View view, boolean z) {
        int i2;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i2 = f72063d | systemUiVisibility;
        } else {
            i2 = (~f72063d) & systemUiVisibility;
        }
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    public static void h(Window window, int i2) {
        try {
            c(window, i2);
            if (Build.VERSION.SDK_INT > 22) {
                g(window.getDecorView(), true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void i(Window window, boolean z) {
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

    public static int j(int i2) {
        return (((((i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7;
    }
}
