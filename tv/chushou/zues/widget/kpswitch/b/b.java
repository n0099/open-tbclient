package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences nRx;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gH(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gH(Context context) {
        if (nRx == null) {
            synchronized (b.class) {
                if (nRx == null) {
                    nRx = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nRx;
    }

    public static int H(Context context, int i) {
        return gH(context).getInt("sp.key.keyboard.height", i);
    }
}
