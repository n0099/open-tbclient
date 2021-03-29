package d.b.f0.l;

import android.content.Context;
/* loaded from: classes2.dex */
public class h {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
