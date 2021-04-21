package d.e.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f66934a;

    public static int a(Context context) {
        c(context);
        return f66934a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f66934a.widthPixels;
    }

    public static void c(Context context) {
        if (f66934a == null) {
            f66934a = context.getResources().getDisplayMetrics();
        }
    }
}
