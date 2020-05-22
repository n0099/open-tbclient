package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences nQn;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gH(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gH(Context context) {
        if (nQn == null) {
            synchronized (b.class) {
                if (nQn == null) {
                    nQn = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nQn;
    }

    public static int H(Context context, int i) {
        return gH(context).getInt("sp.key.keyboard.height", i);
    }
}
