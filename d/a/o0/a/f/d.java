package d.a.o0.a.f;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class d {
    public static void a(String str) {
        d().edit().putBoolean(str, true).apply();
    }

    public static boolean b(String str) {
        return d().getBoolean(str, false);
    }

    public static long c(String str) {
        return d().getLong(str, 0L);
    }

    public static SharedPreferences d() {
        return d.a.o0.a.c.i().g().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static String e(String str, String str2) {
        return d().getString(str, str2);
    }

    public static void f(String str, String str2) {
        d().edit().putString(str, str2).apply();
    }

    public static void g(String str, long j) {
        d().edit().putLong(str, j).apply();
    }
}
