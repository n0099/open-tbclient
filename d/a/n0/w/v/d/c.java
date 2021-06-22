package d.a.n0.w.v.d;

import android.content.Context;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f54673a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f54674b = 50;

    public static synchronized int a(Context context) {
        int i2;
        int identifier;
        synchronized (c.class) {
            if (!f54673a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                f54674b = dimensionPixelSize;
                f54673a = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
            }
            i2 = f54674b;
        }
        return i2;
    }
}
