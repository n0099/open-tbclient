package tv.chushou.basis.a;

import android.annotation.TargetApi;
import android.content.Context;
/* loaded from: classes4.dex */
public class a {
    public static ClassLoader nTJ = b.class.getClassLoader();

    @TargetApi(11)
    public static void e(Context context, String str, long j) {
        context.getSharedPreferences("dynamic_load_configs", 4).edit().putLong(str, j).apply();
    }

    @TargetApi(11)
    public static long bD(Context context, String str) {
        return context.getSharedPreferences("dynamic_load_configs", 4).getLong(str, 0L);
    }
}
