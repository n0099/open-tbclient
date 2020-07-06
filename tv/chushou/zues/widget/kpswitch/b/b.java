package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences onp;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gI(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gI(Context context) {
        if (onp == null) {
            synchronized (b.class) {
                if (onp == null) {
                    onp = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return onp;
    }

    public static int H(Context context, int i) {
        return gI(context).getInt("sp.key.keyboard.height", i);
    }
}
