package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences nvr;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gg(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gg(Context context) {
        if (nvr == null) {
            synchronized (b.class) {
                if (nvr == null) {
                    nvr = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nvr;
    }

    public static int H(Context context, int i) {
        return gg(context).getInt("sp.key.keyboard.height", i);
    }
}
