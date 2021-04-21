package d.b.h0.l.q;

import android.content.SharedPreferences;
import d.b.h0.l.r.g;
/* loaded from: classes3.dex */
public class a {
    public static long a(int i) {
        SharedPreferences a2 = g.a();
        return a2.getLong("latest_update_time" + i, 0L);
    }

    public static long b(int i) {
        SharedPreferences a2 = g.a();
        return a2.getLong("max_age" + i, 0L);
    }

    public static boolean c(int i) {
        return (System.currentTimeMillis() - a(i)) / 1000 > b(i);
    }

    public static void d(int i, long j) {
        SharedPreferences.Editor edit = g.a().edit();
        edit.putLong("latest_update_time" + i, j).apply();
    }

    public static void e(int i, long j) {
        if (j <= 0 || j >= 259200) {
            j = 0;
        }
        g.a().edit().putLong("max_age" + i, j).apply();
    }
}
