package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences onm;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gI(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gI(Context context) {
        if (onm == null) {
            synchronized (b.class) {
                if (onm == null) {
                    onm = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return onm;
    }

    public static int H(Context context, int i) {
        return gI(context).getInt("sp.key.keyboard.height", i);
    }
}
