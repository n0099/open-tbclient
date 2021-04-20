package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f66787a;

    public static int a(Context context) {
        c(context);
        return f66787a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f66787a.widthPixels;
    }

    public static void c(Context context) {
        if (f66787a == null) {
            f66787a = context.getResources().getDisplayMetrics();
        }
    }
}
