package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
class b {
    private static volatile SharedPreferences nvo;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gs(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gs(Context context) {
        if (nvo == null) {
            synchronized (b.class) {
                if (nvo == null) {
                    nvo = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return nvo;
    }

    public static int H(Context context, int i) {
        return gs(context).getInt("sp.key.keyboard.height", i);
    }
}
