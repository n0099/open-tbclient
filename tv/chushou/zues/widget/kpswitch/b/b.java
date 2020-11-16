package tv.chushou.zues.widget.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {
    private static volatile SharedPreferences qrg;

    b() {
    }

    public static boolean P(Context context, int i) {
        return hM(context).edit().putInt("sp.key.keyboard.height", i).commit();
    }

    private static SharedPreferences hM(Context context) {
        if (qrg == null) {
            synchronized (b.class) {
                if (qrg == null) {
                    qrg = context.getSharedPreferences("keyboard.common", 0);
                }
            }
        }
        return qrg;
    }

    public static int Q(Context context, int i) {
        return hM(context).getInt("sp.key.keyboard.height", i);
    }
}
