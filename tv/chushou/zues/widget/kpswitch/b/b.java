package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
class b {
    private static volatile SharedPreferences nYC;

    b() {
    }

    public static boolean j(Context context, int i) {
        return bd(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences bd(Context context) {
        if (nYC == null) {
            synchronized (b.class) {
                if (nYC == null) {
                    nYC = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nYC;
    }

    public static int k(Context context, int i) {
        return bd(context).getInt("sp.key.keyboard.height", i);
    }
}
