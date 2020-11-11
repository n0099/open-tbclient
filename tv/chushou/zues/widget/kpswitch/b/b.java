package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {
    private static volatile SharedPreferences qpD;

    b() {
    }

    public static boolean P(Context context, int i) {
        return hO(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hO(Context context) {
        if (qpD == null) {
            synchronized (b.class) {
                if (qpD == null) {
                    qpD = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return qpD;
    }

    public static int Q(Context context, int i) {
        return hO(context).getInt("sp.key.keyboard.height", i);
    }
}
