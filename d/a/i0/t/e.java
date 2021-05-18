package d.a.i0.t;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f48318a = Arrays.asList("TAH-AN00", "TET-AN00");

    public static int a(Activity activity) {
        double b2 = b(activity) * 0.5199999809265137d;
        if (b2 < 1148.0d) {
            return 1148;
        }
        return (int) b2;
    }

    public static double b(Activity activity) {
        if (c(activity)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return 0.0d;
    }

    public static boolean c(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (TextUtils.equals("HUAWEI", str) && !TextUtils.isEmpty(str2)) {
            for (String str3 : f48318a) {
                if (str2.contains(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        double d2 = displayMetrics.widthPixels;
        double d3 = displayMetrics.heightPixels;
        return (d2 == 0.0d || d3 == 0.0d || d3 / d2 >= 1.5d) ? false : true;
    }
}
