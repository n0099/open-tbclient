package d.b.g0.a.i2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class d0 {
    public static boolean a(Context context) {
        int i;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = false;
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                i = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            } else {
                i = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            }
            if (i != 0) {
                return false;
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (!"1".equals(str)) {
                z = "0".equals(str) ? true : z2;
            }
            return z;
        } catch (Exception unused) {
            return z2;
        }
    }

    public static Pair<Integer, Integer> b() {
        Pair<Integer, Integer> d2 = d();
        return new Pair<>(Integer.valueOf(((Integer) d2.first).intValue()), Integer.valueOf(((Integer) d2.second).intValue() - c()));
    }

    public static int c() {
        if (e()) {
            return h0.p(AppRuntime.getAppContext().getResources(), h0.E() ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }
        return 0;
    }

    public static Pair<Integer, Integer> d() {
        Context appContext = AppRuntime.getAppContext();
        WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
        if (windowManager == null) {
            return new Pair<>(Integer.valueOf(h0.m(appContext)), Integer.valueOf(h0.l(appContext)));
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static boolean e() {
        Context appContext = AppRuntime.getAppContext();
        if (f(appContext)) {
            return false;
        }
        return a(appContext);
    }

    public static boolean f(Context context) {
        String str = Build.BRAND;
        try {
            if (TextUtils.isEmpty(str)) {
                return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
            }
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return str.equalsIgnoreCase("XIAOMI") ? Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0 : str.equalsIgnoreCase("VIVO") ? Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0 : str.equalsIgnoreCase("OPPO") ? Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0 : str.equalsIgnoreCase("SAMSUNG") ? Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled", 0) != 0 : Settings.Global.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
            }
            return Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
