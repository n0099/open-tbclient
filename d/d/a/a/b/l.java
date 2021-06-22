package d.d.a.a.b;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f69908a;

    public static int a(Context context) {
        c(context);
        return f69908a.heightPixels;
    }

    public static int b(Context context) {
        c(context);
        return f69908a.widthPixels;
    }

    public static void c(Context context) {
        if (f69908a == null) {
            f69908a = context.getResources().getDisplayMetrics();
        }
    }
}
