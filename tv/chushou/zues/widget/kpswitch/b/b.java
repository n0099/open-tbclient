package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {
    private static volatile SharedPreferences oQf;

    b() {
    }

    public static boolean I(Context context, int i) {
        return hh(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hh(Context context) {
        if (oQf == null) {
            synchronized (b.class) {
                if (oQf == null) {
                    oQf = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return oQf;
    }

    public static int J(Context context, int i) {
        return hh(context).getInt("sp.key.keyboard.height", i);
    }
}
