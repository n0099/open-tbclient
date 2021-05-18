package d.a.b0.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f38549a;

    public static Context a() {
        return d.a.b0.a.b.b.a();
    }

    public static long b(String str, long j) {
        return c().getLong(str, j);
    }

    public static SharedPreferences c() {
        if (f38549a == null) {
            f38549a = PreferenceManager.getDefaultSharedPreferences(a());
        }
        return f38549a;
    }

    public static String d(String str, String str2) {
        return c().getString(str, str2);
    }

    public static void e(String str, long j) {
        SharedPreferences.Editor edit = c().edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void f(String str, String str2) {
        SharedPreferences.Editor edit = c().edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
