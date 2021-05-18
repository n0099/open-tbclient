package d.a.i0.a.v2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public final class b0 {
    static {
        boolean z = d.a.i0.a.k.f43025a;
    }

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
        return context.getResources().getColor(d.a.i0.a.c.aiapps_ui_cover_layer_color);
    }
}
