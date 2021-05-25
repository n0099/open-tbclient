package d.a.l0.a.w1.h;

import android.content.Context;
import android.content.SharedPreferences;
import d.a.l0.a.k2.g.g;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SharedPreferences f45592a;

    public static int a(Context context, int i2) {
        return c(context).getInt("softinput.height", i2);
    }

    public static boolean b(Context context, int i2) {
        return c(context).edit().putInt("softinput.height", i2).commit();
    }

    public static SharedPreferences c(Context context) {
        if (f45592a == null) {
            synchronized (e.class) {
                if (f45592a == null) {
                    f45592a = new g("swan.publisher", false);
                }
            }
        }
        return f45592a;
    }
}
