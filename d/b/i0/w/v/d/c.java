package d.b.i0.w.v.d;

import android.content.Context;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f52324a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f52325b = 50;

    public static synchronized int a(Context context) {
        int i;
        int identifier;
        synchronized (c.class) {
            if (!f52324a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                f52325b = dimensionPixelSize;
                f52324a = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
            }
            i = f52325b;
        }
        return i;
    }
}
