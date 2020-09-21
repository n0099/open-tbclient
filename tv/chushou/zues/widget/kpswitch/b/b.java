package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
class b {
    private static volatile SharedPreferences oZA;

    b() {
    }

    public static boolean L(Context context, int i) {
        return hn(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hn(Context context) {
        if (oZA == null) {
            synchronized (b.class) {
                if (oZA == null) {
                    oZA = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return oZA;
    }

    public static int M(Context context, int i) {
        return hn(context).getInt("sp.key.keyboard.height", i);
    }
}
