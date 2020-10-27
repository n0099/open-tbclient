package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
class b {
    private static volatile SharedPreferences qgi;

    b() {
    }

    public static boolean O(Context context, int i) {
        return hO(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hO(Context context) {
        if (qgi == null) {
            synchronized (b.class) {
                if (qgi == null) {
                    qgi = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return qgi;
    }

    public static int P(Context context, int i) {
        return hO(context).getInt("sp.key.keyboard.height", i);
    }
}
