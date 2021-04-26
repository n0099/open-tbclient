package d.a.h0.l.q;

import android.content.SharedPreferences;
import d.a.h0.l.r.g;
/* loaded from: classes3.dex */
public class a {
    public static long a(int i2) {
        SharedPreferences a2 = g.a();
        return a2.getLong("latest_update_time" + i2, 0L);
    }

    public static long b(int i2) {
        SharedPreferences a2 = g.a();
        return a2.getLong("max_age" + i2, 0L);
    }

    public static boolean c(int i2) {
        return (System.currentTimeMillis() - a(i2)) / 1000 > b(i2);
    }

    public static void d(int i2, long j) {
        SharedPreferences.Editor edit = g.a().edit();
        edit.putLong("latest_update_time" + i2, j).apply();
    }

    public static void e(int i2, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.a().edit().putLong("max_age" + i2, j).apply();
    }
}
