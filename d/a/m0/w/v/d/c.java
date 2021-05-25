package d.a.m0.w.v.d;

import android.content.Context;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50889a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f50890b = 50;

    public static synchronized int a(Context context) {
        int i2;
        int identifier;
        synchronized (c.class) {
            if (!f50889a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                f50890b = dimensionPixelSize;
                f50889a = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
            }
            i2 = f50890b;
        }
        return i2;
    }
}
