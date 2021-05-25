package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f66073a;

    public static int a(Context context) {
        c(context);
        return f66073a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f66073a.widthPixels;
    }

    public static void c(Context context) {
        if (f66073a == null) {
            f66073a = context.getResources().getDisplayMetrics();
        }
    }
}
