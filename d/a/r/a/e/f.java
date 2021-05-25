package d.a.r.a.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public final class f {
    public static DisplayMetrics a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "unknown";
        }
    }
}
