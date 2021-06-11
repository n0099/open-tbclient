package d.a.m0.w.v.d;

import android.content.Context;
import android.util.Log;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f54566a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f54567b = 50;

    public static synchronized int a(Context context) {
        int i2;
        int identifier;
        synchronized (c.class) {
            if (!f54566a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                f54567b = dimensionPixelSize;
                f54566a = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(dimensionPixelSize)));
            }
            i2 = f54567b;
        }
        return i2;
    }
}
