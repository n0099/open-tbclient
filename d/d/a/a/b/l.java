package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f65942a;

    public static int a(Context context) {
        c(context);
        return f65942a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f65942a.widthPixels;
    }

    public static void c(Context context) {
        if (f65942a == null) {
            f65942a = context.getResources().getDisplayMetrics();
        }
    }
}
