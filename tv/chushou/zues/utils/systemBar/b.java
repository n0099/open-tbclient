package tv.chushou.zues.utils.systemBar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tv.chushou.zues.b;
import tv.chushou.zues.utils.f;
/* loaded from: classes5.dex */
public class b {
    public static final int nNK = b.C0914b.status_color_dark;
    public static final int nNL = b.C0914b.status_color_lignt;
    private static boolean nNM = false;
    private static int nNN = 50;

    public static int av(Activity activity) {
        int aB = aB(activity);
        if (aB > 0) {
            a(activity, ContextCompat.getColor(activity, nNL), 0);
        } else {
            a(activity, ContextCompat.getColor(activity, nNK), 0);
        }
        return aB;
    }

    public static int aw(Activity activity) {
        if (ax(activity)) {
            return bi(activity, "navigation_bar_height");
        }
        return 0;
    }

    public static int gA(Context context) {
        if (!gE(context) || gF(context) || gG(context)) {
            return 0;
        }
        return bi(context, "navigation_bar_height");
    }

    public static int gB(Context context) {
        if (!gE(context) || gF(context) || gG(context)) {
            return 0;
        }
        return bi(context, "navigation_bar_width");
    }

    public static boolean gC(Context context) {
        return gE(context) && !gF(context) && !gG(context) && bi(context, "navigation_bar_width") > 0;
    }

    public static boolean ax(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(activity).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.y == point.y && point2.x == point.x) ? false : true;
    }

    public static boolean ay(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            return point2.x != point.x;
        }
        return true;
    }

    public static int getStatusBarHeight(Context context) {
        if (!nNM) {
            nNN = bi(context, "status_bar_height");
            if (nNN > 0) {
                nNM = true;
            }
        }
        return nNN;
    }

    public static int gD(Context context) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return 0;
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    private static boolean gE(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if (z && hasSmartBar()) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    String str = f.get("qemu.hw.mainkeys");
                    if ("1".equals(str)) {
                        r0 = false;
                    } else if (!"0".equals(str)) {
                        if (!z) {
                            if (tv.chushou.zues.utils.a.gw(context).y == tv.chushou.zues.utils.a.gv(context).y) {
                                r0 = false;
                            }
                        }
                    }
                    return r0;
                }
                r0 = z;
                return r0;
            }
            return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
        }
        return false;
    }

    public static boolean gF(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0);
        } catch (Exception e) {
            i = 0;
        }
        return i != 0;
    }

    public static boolean gG(Context context) {
        int i;
        try {
            i = Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) : 0;
        } catch (Exception e) {
            i = 0;
        }
        return i != 0;
    }

    private static boolean hasSmartBar() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                return true;
            }
            return (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) ? false : false;
        }
    }

    public static boolean a(Activity activity, @ColorInt int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(calculateStatusColor(i, i2));
            return true;
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            int childCount = viewGroup.getChildCount();
            if (childCount > 0 && (viewGroup.getChildAt(childCount - 1) instanceof StatusBarView)) {
                viewGroup.getChildAt(childCount - 1).setBackgroundColor(calculateStatusColor(i, i2));
            } else {
                viewGroup.addView(b(activity, i, i2));
            }
            az(activity);
            return true;
        } else {
            return false;
        }
    }

    private static StatusBarView b(Activity activity, @ColorInt int i, int i2) {
        StatusBarView statusBarView = new StatusBarView(activity);
        statusBarView.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        statusBarView.setBackgroundColor(calculateStatusColor(i, i2));
        return statusBarView;
    }

    private static void az(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    private static int calculateStatusColor(@ColorInt int i, int i2) {
        float f = 1.0f - (i2 / 255.0f);
        return ((int) ((f * (i & 255)) + 0.5d)) | (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8);
    }

    private static int bi(Context context, String str) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    @TargetApi(19)
    public static void aA(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            Window window2 = activity.getWindow();
            window2.setFlags(67108864, 67108864);
            window2.addFlags(512);
            window2.addFlags(256);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int aB(Activity activity) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 19) {
            if (!b(activity.getWindow(), true)) {
                if (a(activity.getWindow(), true)) {
                    i = 2;
                } else if (Build.VERSION.SDK_INT >= 23) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(9216);
                    i = 3;
                }
            }
            if (i > 0) {
                az(activity);
            }
            return i;
        }
        i = 0;
        if (i > 0) {
        }
        return i;
    }

    public static boolean a(Window window, boolean z) {
        int i;
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (z) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                if (Build.VERSION.SDK_INT < 23 || !Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                    return true;
                }
                window.getDecorView().setSystemUiVisibility(9216);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
