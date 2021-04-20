package d.b.i0.j1.o.k;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
/* loaded from: classes4.dex */
public class e {
    public static int a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean b() {
        return a() >= 14;
    }

    public static boolean c(Activity activity) {
        Resources resources;
        int identifier;
        if (!b() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", "android")) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }
}
