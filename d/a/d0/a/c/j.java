package d.a.d0.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f43390a;

    public static Context a() {
        return d.a.d0.a.b.b.a();
    }

    public static float b(String str, float f2) {
        return e().getFloat(str, f2);
    }

    public static int c(String str, int i2) {
        return e().getInt(str, i2);
    }

    public static long d(String str, long j) {
        return e().getLong(str, j);
    }

    public static SharedPreferences e() {
        if (f43390a == null) {
            f43390a = PreferenceManager.getDefaultSharedPreferences(a());
        }
        return f43390a;
    }

    public static String f(String str, String str2) {
        return e().getString(str, str2);
    }

    public static void g(String str, float f2) {
        SharedPreferences.Editor edit = e().edit();
        edit.putFloat(str, f2);
        edit.apply();
    }

    public static void h(String str, int i2) {
        SharedPreferences.Editor edit = e().edit();
        edit.putInt(str, i2);
        edit.apply();
    }

    public static void i(String str, long j) {
        SharedPreferences.Editor edit = e().edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void j(String str, String str2) {
        SharedPreferences.Editor edit = e().edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
