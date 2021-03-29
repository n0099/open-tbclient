package d.m.b.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static double f66294a = -1.0d;

    public static String a() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String a2;
        d.m.b.b.d.a e2 = com.pgl.sys.ces.b.e();
        if (e2 != null) {
            try {
                a2 = e2.a();
            } catch (Throwable unused) {
            }
            return a2 != null ? "" : a2.trim();
        }
        a2 = "";
        if (a2 != null) {
        }
    }

    public static String c() {
        String str;
        d.m.b.b.d.a e2;
        try {
            e2 = com.pgl.sys.ces.b.e();
        } catch (Throwable unused) {
        }
        if (e2 != null) {
            str = e2.e();
            return "" + str;
        }
        str = "";
        return "" + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        String b2;
        d.m.b.b.d.a e2 = com.pgl.sys.ces.b.e();
        if (e2 != null) {
            try {
                b2 = e2.b();
            } catch (Throwable unused) {
            }
            return b2 != null ? "" : b2.trim();
        }
        b2 = null;
        if (b2 != null) {
        }
    }

    public static String e(Context context) {
        String str;
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            str = locale.getLanguage() + "_" + locale.getCountry();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String f(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String g(Context context) {
        int i;
        double d2 = f66294a;
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            i = (int) d2;
        } else {
            try {
                Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
                Object newInstance = cls.getConstructor(Context.class).newInstance(context);
                Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
                declaredMethod.setAccessible(true);
                d3 = ((Double) declaredMethod.invoke(newInstance, "battery.capacity")).doubleValue();
            } catch (Throwable unused) {
            }
            f66294a = d3;
            i = (int) d3;
        }
        return Integer.toString(i);
    }
}
