package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f65941a;

    public static int a(Context context) {
        c(context);
        return f65941a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f65941a.widthPixels;
    }

    public static void c(Context context) {
        if (f65941a == null) {
            f65941a = context.getResources().getDisplayMetrics();
        }
    }
}
