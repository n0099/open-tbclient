package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences nZD;

    b() {
    }

    public static boolean j(Context context, int i) {
        return bh(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences bh(Context context) {
        if (nZD == null) {
            synchronized (b.class) {
                if (nZD == null) {
                    nZD = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nZD;
    }

    public static int k(Context context, int i) {
        return bh(context).getInt("sp.key.keyboard.height", i);
    }
}
