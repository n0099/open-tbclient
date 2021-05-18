package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f66030a;

    public static int a(Context context) {
        c(context);
        return f66030a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f66030a.widthPixels;
    }

    public static void c(Context context) {
        if (f66030a == null) {
            f66030a = context.getResources().getDisplayMetrics();
        }
    }
}
