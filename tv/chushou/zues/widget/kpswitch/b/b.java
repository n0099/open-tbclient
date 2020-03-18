package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences obr;

    b() {
    }

    public static boolean j(Context context, int i) {
        return bg(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences bg(Context context) {
        if (obr == null) {
            synchronized (b.class) {
                if (obr == null) {
                    obr = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return obr;
    }

    public static int k(Context context, int i) {
        return bg(context).getInt("sp.key.keyboard.height", i);
    }
}
