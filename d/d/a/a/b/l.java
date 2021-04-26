package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f65344a;

    public static int a(Context context) {
        c(context);
        return f65344a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f65344a.widthPixels;
    }

    public static void c(Context context) {
        if (f65344a == null) {
            f65344a = context.getResources().getDisplayMetrics();
        }
    }
}
