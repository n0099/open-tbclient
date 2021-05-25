package d.a.l0.a.i1.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public final class c {
    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i2) {
        if (context == null || drawable == null) {
            return;
        }
        int d2 = d(context);
        if (i2 >= 0 && i2 < 255) {
            d2 = Color.argb((Color.alpha(d2) * i2) / 255, Color.red(d2), Color.green(d2), Color.blue(d2));
        }
        drawable.setColorFilter(d2, mode);
    }

    public static void b(Context context, Drawable drawable) {
        c(context, drawable, 255);
    }

    public static void c(Context context, Drawable drawable, int i2) {
        a(context, drawable, PorterDuff.Mode.SRC_ATOP, i2);
    }

    public static int d(Context context) {
        return 0;
    }
}
