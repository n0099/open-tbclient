package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
class b {
    private static volatile SharedPreferences poW;

    b() {
    }

    public static boolean L(Context context, int i) {
        return hu(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hu(Context context) {
        if (poW == null) {
            synchronized (b.class) {
                if (poW == null) {
                    poW = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return poW;
    }

    public static int M(Context context, int i) {
        return hu(context).getInt("sp.key.keyboard.height", i);
    }
}
