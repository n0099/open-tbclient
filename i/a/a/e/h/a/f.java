package i.a.a.e.h.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes8.dex */
public class f {
    public static int a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.hw_emui_api_level");
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b() {
        return g() ? f("ro.build.version.emui", "") : "";
    }

    public static String c() {
        return f("ro.build.display.id", "");
    }

    public static String d() {
        return j() ? f("ro.build.display.id", "") : "";
    }

    public static String e() {
        return l() ? f("ro.miui.ui.version.name", "") : "";
    }

    public static String f(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean g() {
        return a() > 0;
    }

    public static boolean h() {
        return b().contains("EmotionUI_3.0");
    }

    public static boolean i() {
        String b2 = b();
        return "EmotionUI 3".equals(b2) || b2.contains("EmotionUI_3.1");
    }

    public static boolean j() {
        return c().toLowerCase().contains(ImmersiveOSUtils.FLYME);
    }

    public static boolean k() {
        int intValue;
        String d2 = d();
        if (d2.isEmpty()) {
            return false;
        }
        try {
            if (d2.toLowerCase().contains(IAdRequestParam.OS)) {
                intValue = Integer.valueOf(d2.substring(9, 10)).intValue();
            } else {
                intValue = Integer.valueOf(d2.substring(6, 7)).intValue();
            }
            return intValue >= 4;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean l() {
        return !TextUtils.isEmpty(f("ro.miui.ui.version.name", ""));
    }

    public static boolean m() {
        String e2 = e();
        if (e2.isEmpty()) {
            return false;
        }
        try {
            return Integer.valueOf(e2.substring(1)).intValue() >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean n() {
        return "OPPO".equals(Build.MANUFACTURER);
    }
}
