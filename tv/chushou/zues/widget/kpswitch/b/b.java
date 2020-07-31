package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {
    private static volatile SharedPreferences ovU;

    b() {
    }

    public static boolean G(Context context, int i) {
        return gP(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences gP(Context context) {
        if (ovU == null) {
            synchronized (b.class) {
                if (ovU == null) {
                    ovU = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return ovU;
    }

    public static int H(Context context, int i) {
        return gP(context).getInt("sp.key.keyboard.height", i);
    }
}
