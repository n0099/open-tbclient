package d.a.i0.a.w1.h;

import android.content.Context;
import android.content.SharedPreferences;
import d.a.i0.a.k2.g.g;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SharedPreferences f45416a;

    public static int a(Context context, int i2) {
        return c(context).getInt("softinput.height", i2);
    }

    public static boolean b(Context context, int i2) {
        return c(context).edit().putInt("softinput.height", i2).commit();
    }

    public static SharedPreferences c(Context context) {
        if (f45416a == null) {
            synchronized (e.class) {
                if (f45416a == null) {
                    f45416a = new g("swan.publisher", false);
                }
            }
        }
        return f45416a;
    }
}
